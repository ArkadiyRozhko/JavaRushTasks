package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream=new FileInputStream(args[0]);
        int summSpace=0;
        int summChar=0;
        while (inputStream.available()>0){
            int ch=inputStream.read();
            summChar++;
            if (ch == 32) {
                summSpace++;
            }
        }
        inputStream.close();
        double result=(double)summSpace/summChar*100;
        System.out.format("%.2f",result);

    }
}
