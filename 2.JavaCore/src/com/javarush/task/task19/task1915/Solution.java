package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String path=reader.readLine();
        reader.close();
        PrintStream standartOut=System.out;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        PrintStream newPrintStream=new PrintStream(byteArrayOutputStream);
        System.setOut(newPrintStream);
        testString.printSomething();
        System.setOut(standartOut);
        String result=byteArrayOutputStream.toString();
        System.out.println(result);
        byte [] bytes=byteArrayOutputStream.toByteArray();

        try (FileOutputStream outputStream=new FileOutputStream(path)){
            outputStream.write(bytes,0,bytes.length);
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

