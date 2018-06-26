package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2=reader.readLine();
        String file3=reader.readLine();

        FileInputStream inputStream=new FileInputStream(file1);
        FileOutputStream outputStream2=new FileOutputStream(file2);
        FileOutputStream outputStream3=new FileOutputStream(file3);
        int size=inputStream.available();
        while (inputStream.available()>0){
            if (size%2 == 0) {
                byte[] buffer=new byte[size/2];
                if (inputStream.available()>size/2) {
                    inputStream.read(buffer);
                    outputStream2.write(buffer);
                }else {
                    inputStream.read(buffer);
                    outputStream3.write(buffer);
                }
            }else {
                byte[] buffer=new byte[(size/2)+1];
                if (inputStream.available()>(size/2)+1) {
                    inputStream.read(buffer);
                    outputStream2.write(buffer);
                }else {
                    int count=inputStream.read(buffer);
                    outputStream3.write(buffer,0,count);
                }
            }
        }
        inputStream.close();
        outputStream2.close();
        outputStream3.close();
    }
}
