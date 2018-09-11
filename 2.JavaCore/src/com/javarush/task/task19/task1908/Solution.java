package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileIn=reader.readLine();
        String fileOut=reader.readLine();
        reader.close();
        FileReader fileReader=new FileReader(fileIn);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        FileWriter fileWriter=new FileWriter(fileOut);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        String str;
        while ((str=bufferedReader.readLine())!=null) {
            String[] words = str.split("\\s*(\\s|,|!|\\.)\\s*");
            for (String s : words
                    ) {
                if (IsDigit(s)) {
                    bufferedWriter.write(s + " ");
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();

    }
    public static boolean IsDigit(String s){
        try {
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }catch (NullPointerException e){
            return false;
        }
        return true;
    }
}
