package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int minindex=0;
        list.add(reader.readLine());
        for (int i = 1; i < 10; i++) {
            list.add(reader.readLine());
            if (list.get(i).length()<list.get(minindex).length()) {
                System.out.println(i);
                break;
            }
            minindex++;
        }

    }
}

