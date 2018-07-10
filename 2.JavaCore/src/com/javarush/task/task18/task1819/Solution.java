package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        FileInputStream inputStream=new FileInputStream(file1);

        FileInputStream inputStream1=new FileInputStream(file2);
        ArrayList<Integer>first=new ArrayList<>();
        while (inputStream1.available()>0){
            first.add(inputStream1.read());
        }
        while (inputStream.available()>0){
            first.add(inputStream.read());
        }
        inputStream.close();
        inputStream1.close();
        FileOutputStream outputStream = new FileOutputStream(file1);
        for (int i:first
             ) {
            outputStream.write(i);
        }
        outputStream.close();
    }
}
