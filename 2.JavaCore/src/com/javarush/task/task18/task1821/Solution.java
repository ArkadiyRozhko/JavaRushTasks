package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream=new FileInputStream(args[0]);
        TreeMap<Byte,Integer> treeMap=new TreeMap<Byte,Integer>();
        while (inputStream.available()>0){
            byte tmp=(byte) inputStream.read();
            if (treeMap.containsKey(tmp)){
                Integer i= (Integer) treeMap.get(tmp);
                i++;
                treeMap.put((byte) tmp,i);
            }else {

                treeMap.put((byte) tmp,1);
            }
        }
        for (Map.Entry<Byte,Integer> item:treeMap.entrySet()
             ) {
            byte key=item.getKey();
            char charKey=(char) key;
            int value=item.getValue();
            System.out.println(charKey + " "+ value);

        }
        inputStream.close();



    }
}
