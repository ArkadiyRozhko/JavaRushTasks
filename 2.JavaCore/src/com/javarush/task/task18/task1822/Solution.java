package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String filePath=reader.readLine();
        try (BufferedReader reader1=new BufferedReader(new FileReader(filePath))){
            String str;
            while ((str=reader1.readLine())!=null){
                String[] words=str.split("\\s");

                if (Integer.parseInt(words[0]) == Integer.parseInt( args[0])) {
                    System.out.println(str);
                }
            }
        }

    }
}
