package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String path=reader.readLine();
        FileInputStream fis=new FileInputStream(path);
        load(fis);
        fis.close();
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop=new Properties();
        prop.putAll(properties);
        prop.store(outputStream,"my prop");


    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop=new Properties();
        prop.load(inputStream);
        properties.putAll((Map)prop);
    }

    public static void main(String[] args) {

    }
}
