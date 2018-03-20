package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("Vasya",1000);
        map.put("Petya",500);
        map.put("Valya",1000);
        map.put("Vaseluna",500);
        map.put("Dima",1000);
        map.put("Sasha",1000);
        map.put("Vanya",1000);
        map.put("Lena",1000);
        map.put("Lesya",1000);
        map.put("Luka",1000);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Integer>>iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer>pair=iterator.next();
            if (pair.getValue()<500)
                iterator.remove();
        }

    }

    public static void main(String[] args) {
        HashMap map=createMap();
        removeItemFromMap(map);

    }
}