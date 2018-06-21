package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        int min = 255;
        FileInputStream inputStream = new FileInputStream(path);
        while (inputStream.available()>0){
            int tmp = inputStream.read();
            if (tmp<min){
                min=tmp;
            }
        }
        inputStream.close();
        System.out.println(min);
    }
}
