package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int key=22;
        String Shifr=args[0];
        String fileNameInput=args[1];
        String fileNameOutput=args[2];
        FileInputStream inputStream=new FileInputStream(fileNameInput);
        FileOutputStream outputStream=new FileOutputStream(fileNameOutput);
        if (Shifr.equals("-e")) {
            while (inputStream.available()>0){
                outputStream.write(inputStream.read()+key);
            }
        }else if (Shifr.equals("-d")){
            while (inputStream.available()>0){
                outputStream.write(inputStream.read()-key);
            }
        }
        inputStream.close();
        outputStream.close();


    }

}
