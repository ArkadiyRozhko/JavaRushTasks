package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream standartprintStream=System.out;
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        PrintStream printStream=new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        String s=outputStream.toString().toUpperCase();
        System.setOut(standartprintStream);
        StringBuilder builder=new StringBuilder(s);
        System.out.println(s);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
