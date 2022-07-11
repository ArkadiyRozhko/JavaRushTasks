package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        String fileName=args[0];
        int number=Integer.parseInt(args[1]);
        byte[] text = args[2].getBytes();

        try {
            RandomAccessFile file=new RandomAccessFile(fileName,"rw");
            if (number < file.length()) {
                file.seek(number);
            }else {
                file.seek(file.length());
            }
            file.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
