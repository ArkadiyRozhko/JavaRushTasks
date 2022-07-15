package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try {
            RandomAccessFile file = new RandomAccessFile(fileName,"rw");
            file.seek(number);
            byte[] temp =new byte[text.length()];
            file.read(temp,0,text.length());
            file.seek(file.length());
            if (Arrays.equals(temp,text.getBytes())) {
                file.write(("true").getBytes(StandardCharsets.UTF_8));
            }else {
                file.write(("false").getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
