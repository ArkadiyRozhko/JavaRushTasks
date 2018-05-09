package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            Map<String,String>test=Param(url);
            for (Map.Entry<String,String>item:test.entrySet()){
                System.out.print(item.getKey()+ " ");
            }
            System.out.println();
            ObjParam(test);

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
    static void ObjParam(Map<String,String> map){
        if (map.containsKey("obj")) {
            try {
                double d = Double.parseDouble(map.get("obj"));
                alert(d);
            }catch (Exception e){
                alert(map.get("obj"));
            }
        }
    }

}
