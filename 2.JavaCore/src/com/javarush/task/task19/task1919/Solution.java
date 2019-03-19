package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.nio.file.Files;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Map<String,Double> map=new TreeMap<>();
        try (BufferedReader reader= new BufferedReader(new FileReader(args[0]))){
            String line;
            String name="";
            Double nameValue=0.0;
            String[]temp;
            while ((line=reader.readLine())!=null){
                temp=line.split(" ");
                name=temp[0].trim();
                nameValue=Double.parseDouble(temp[1].trim());
                Double d=map.get(name);
                if (map.get(name) != null) {
                    map.put(name, map.get(name) + nameValue);
                }else {
                    map.put(name,nameValue);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String,Double> item:map.entrySet()
             ) {
            System.out.println(item.getKey()+" "+item.getValue());
        }
    }
}
