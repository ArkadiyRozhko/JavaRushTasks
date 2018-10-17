package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileIn=reader.readLine();
        String fileOut=reader.readLine();
        reader.close();
        BufferedReader bufferedReader=new BufferedReader(new FileReader(fileIn));
        BufferedWriter writer=new BufferedWriter(new FileWriter(fileOut));
        StringBuilder builder=new StringBuilder();

        while (bufferedReader.ready()){
            int data=bufferedReader.read();
            builder.append((char) data);
        }
        bufferedReader.close();
        String result=builder.toString().replaceAll("\\p{Punct}", "");
        String s=result.replaceAll("\n","");
        writer.write(s);
        writer.close();
    }
}
