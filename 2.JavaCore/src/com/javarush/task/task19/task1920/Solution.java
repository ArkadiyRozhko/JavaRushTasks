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
                if (line.isEmpty()) {
                    continue;
                }
                String[]temp=line.split(" ");
                if (Emloee.get(temp[0]) != null) {
                    Emloee.put(temp[0],Emloee.get(temp[0])+Double.parseDouble(temp[1]));
                }else {
                    Emloee.put(temp[0],Double.parseDouble(temp[1]));
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Double max=Collections.max(Emloee.values());
//        for (Double d:Emloee.values()
//                ) {
//            if (d>=max) {
//                max=d;
//            }
//        }
        for (Map.Entry<String,Double> item:Emloee.entrySet()
                ) {
            String k=item.getKey();
            Double v=item.getValue();
            if (v.equals(max)) {
                System.out.println(k);
            }
        }

    }
}
