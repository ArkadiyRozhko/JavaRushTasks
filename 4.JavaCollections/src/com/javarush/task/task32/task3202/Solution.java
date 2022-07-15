package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            StringBuilder builder=new StringBuilder();
            while (is.available()>0){
                int simbol= is.read();
                builder.append(Character.toChars(simbol));
            }
            writer.write(builder.toString());
        }

        return writer;

    }
}
