package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream=System.out;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        PrintStream outToByteArrayStream=new PrintStream(byteArrayOutputStream);
        System.setOut(outToByteArrayStream);
        testString.printSomething();
        String[] result=byteArrayOutputStream.toString().split("\n");
        System.setOut(consoleStream);
        for (int i = 1; i <result.length+1 ; i++) {
            if (i%2 == 0) {
                System.out.println(result[i-1]);
                System.out.println("JavaRush - курсы Java онлайн");
            }else System.out.println(result[i-1]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
