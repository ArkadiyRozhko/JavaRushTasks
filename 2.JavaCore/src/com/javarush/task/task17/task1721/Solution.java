package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1=null;
        BufferedReader file2=null;

        try {
            file1=new BufferedReader(new FileReader(reader.readLine()));
            String s=null;
            String s2=null;
            while ((s=file1.readLine())!=null){
                allLines.add(s);
            }
            file2=new BufferedReader(new FileReader(reader.readLine()));
            while ((s2=file2.readLine())!=null){
                forRemoveLines.add(s2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution solution=new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

        reader.close();
        file1.close();
        file2.close();


    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else {
            allLines.clear();
            throw new  CorruptedDataException();
        }
    }
}
