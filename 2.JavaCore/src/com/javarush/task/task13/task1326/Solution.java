package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        ArrayList<Integer> list=new ArrayList<Integer>();
        reader=new BufferedReader(new InputStreamReader(new FileInputStream(path)));

            while (reader.ready()){
                int x = Integer.parseInt(reader.readLine());
                if (x%2==0) {
                    list.add(x);
                }
            }
            reader.close();
            Collections.sort(list);
            for (int a:list) {
                System.out.println(a);
            }


    }
}
