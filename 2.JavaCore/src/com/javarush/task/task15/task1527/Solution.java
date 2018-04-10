package com.javarush.task.task15.task1527;

import com.sun.javafx.collections.MappingChange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
            System.out.println();
            System.out.println();
            Map<String,String>test=Param(url);
            for (Map.Entry<String,String>item:test.entrySet()){
                System.out.print(item.getKey()+ " ");
            }

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
    static Map<String,String> Param(String str){
        Map<String,String>p=new LinkedHashMap<>();
        String param=Parameters(str);
        for (String words:param.split("&")) {
                if (words.indexOf("=")!=-1) {
                    int index = words.indexOf("=");
                    p.put(words.substring(0, index), words.substring(index + 1));
                }else {
                    p.put(words,"");
                }
        }
        return p;
    }

}
