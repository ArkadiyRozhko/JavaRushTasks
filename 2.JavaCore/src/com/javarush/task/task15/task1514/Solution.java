package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(21.5,"test1");
        labels.put(2.5,"test2");
        labels.put(2.0,"test3");
        labels.put(1.5,"test4");
        labels.put(121.5,"test5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
