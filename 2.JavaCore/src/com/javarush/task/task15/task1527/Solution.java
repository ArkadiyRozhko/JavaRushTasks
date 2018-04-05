package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            String url = reader.readLine();
            System.out.println(Parameters(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    static String Parameters(String url){
        return url.substring(url.indexOf('?')+1);
    }

}
