package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String path=reader.readLine();
        reader.close();
        FileReader fileReader=new FileReader(path);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String str;
        int count=0;
        while ((str = bufferedReader.readLine())!=null){
            String[]words=str.split("\\s*(\\s|,|!|\\.)\\s*");
            for (String s:words
                 ) {
                if (s.equals("world")) {
                    count++;
                }
            }
        }
        fileReader.close();
        bufferedReader.close();
        System.out.println(count);

    }

}
