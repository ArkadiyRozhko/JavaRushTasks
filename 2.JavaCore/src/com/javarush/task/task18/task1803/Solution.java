package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String path=reader.readLine();
        FileInputStream inputStream=new FileInputStream(path);
        int[]bytes=new int[256];
        for (int i = 0; i <256 ; i++) {
            bytes[i]=0;
        }
        while (inputStream.available()>0){
            int temp=inputStream.read();
            bytes[temp]++;
        }
        inputStream.close();
        int index=0;
        int max=bytes[index];

        for (int i = 1; i <256 ; i++) {
            if (max<bytes[i]) {
                max=bytes[i];
                index=i;
            }
        }

        for (int i = 0; i <bytes.length ; i++) {
            if (bytes[i]==max){
                System.out.print(i+" ");
            }
        }

    }
}
