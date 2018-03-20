package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] street = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <street.length ; i++) {
            street[i]=Integer.parseInt(reader.readLine());
        }
        int event=0;
        int odd=0;

        for (int i = 0; i <street.length ; i++) {
            if (i%2==0) {
                event += street[i];
            }else {
                odd+=street[i];
            }

        }
        if (event>odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }

    }
}
