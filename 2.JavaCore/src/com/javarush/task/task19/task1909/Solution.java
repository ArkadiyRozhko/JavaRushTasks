package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileIn=reader.readLine();
        String fileOut=reader.readLine();
        reader.close();
        FileReader fileReader=new FileReader(fileIn);
        FileWriter fileWriter=new FileWriter(fileOut);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        String str;
        while ((str=bufferedReader.readLine())!=null){
            char[]symbols=str.toCharArray();
            for (int i = 0; i <symbols.length ; i++) {
                if (symbols[i]=='.'){
                    symbols[i]='!';
                }
                System.out.println(symbols[i]);
                bufferedWriter.write(symbols[i]);
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
