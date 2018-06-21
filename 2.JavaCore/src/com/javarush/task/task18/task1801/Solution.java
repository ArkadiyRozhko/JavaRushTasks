package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path=reader.readLine();
        FileInputStream inputStream= new FileInputStream(path);
        int max=0;
        while (inputStream.available()>0){
            int tmp = inputStream.read();
            if (max < tmp) max = tmp;
        }
        inputStream.close();
        System.out.println(max);

    }
}
