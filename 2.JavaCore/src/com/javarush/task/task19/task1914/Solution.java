package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldStream=System.out;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        PrintStream newStream=new PrintStream(byteArrayOutputStream);
        System.setOut(newStream);
        testString.printSomething();
        System.setOut(oldStream);
        String s=byteArrayOutputStream.toString();
        String resultStr=s.replaceAll("\r\n","");
        String[] strings=resultStr.split(" ");
        int firstDigit=Integer.parseInt(strings[0]);
        int secondDigit=Integer.parseInt(strings[2]);
        switch (strings[1]){
            case "+":
                int result = firstDigit+secondDigit;
                System.out.println(resultStr+result);
                break;
            case "-":
                int result1 = firstDigit-secondDigit;
                System.out.println(resultStr+result1);
                break;
            case "*":
                int result2 = firstDigit*secondDigit;
                System.out.println(resultStr+result2);
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

