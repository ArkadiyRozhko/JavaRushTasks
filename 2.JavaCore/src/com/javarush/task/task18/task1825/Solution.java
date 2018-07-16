package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> fileNames=new TreeSet<>();
        String fileName;
        while (!(fileName=reader.readLine()).equals("end")){
            fileNames.add(fileName);
        }
        String outFileName=fileNames.first().substring(0,fileNames.first().lastIndexOf('.'));
        FileInputStream inputStream;
        FileOutputStream outputStream=new FileOutputStream(outFileName);
        for (String item:fileNames
             ) {
            inputStream=new FileInputStream(item);
            byte[]buffer=new byte[1000];
            while (inputStream.available()>0){
                int count=inputStream.read(buffer);
                outputStream.write(buffer,0,count);
            }
            inputStream.close();
        }
        outputStream.close();
    }
}
