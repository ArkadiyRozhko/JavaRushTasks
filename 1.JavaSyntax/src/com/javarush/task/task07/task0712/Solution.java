package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int minindex=0, maxindex=0;
        for (int i = 0; i <10 ; i++) {
            if (list.get(minindex).length()>list.get(i).length()) {
                minindex=i;
            }
            if (list.get(maxindex).length()<list.get(i).length()) {
                maxindex=i;
            }
        }
        System.out.println(minindex<maxindex?list.get(minindex):list.get(maxindex));



    }
}
