package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String path=reader.readLine();
        int[]bytes=new int[256];
        for (int i = 0; i <bytes.length ; i++) {
            bytes[i]=-1;
        }
        FileInputStream fileInputStream=new FileInputStream(path);
        while (fileInputStream.available()>0){
            bytes[fileInputStream.read()]++;
        }
        fileInputStream.close();

        for (int i = 0; i <bytes.length ; i++) {
            if (bytes[i] == 0) {
                System.out.print(i+" ");
            }
        }

    }
}
