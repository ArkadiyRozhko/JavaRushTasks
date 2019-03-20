package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<String,Double>Emloee=new TreeMap<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(args[0]))){
            String line;
            while ((line=reader.readLine())!=null){
                String[]temp=line.split(" ");
                if (Emloee.get(temp[0]) != null) {
                    Emloee.put(temp[0],Double.parseDouble(temp[1])+Double.parseDouble(temp[1]));
                }else {
                    Emloee.put(temp[0],Double.parseDouble(temp[1]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Double max=0.0;
        for (Double d:Emloee.values()
             ) {
            if (d >max) {
                max=d;
            }
        }
        List<String>names=new ArrayList<>();
        for (String s:Emloee.keySet()
             ) {
            if (Emloee.get(s) == max) {
                names.add(s);
            }
        }
        Collections.sort(names);
        for (String s:names
             ) {
            System.out.println(s);
        }

    }
}
