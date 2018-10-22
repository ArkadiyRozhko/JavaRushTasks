package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream standartOut=System.out;
        ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
        PrintStream newPrintStream=new PrintStream(arrayOutputStream);
        System.setOut(newPrintStream);
        testString.printSomething();
        String s=arrayOutputStream.toString();
        System.setOut(standartOut);

        s=s.replace("te","??");
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
