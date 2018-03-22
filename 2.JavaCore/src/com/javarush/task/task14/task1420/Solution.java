package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Euclid(7920,594));

    }
    static int Euclid(int a, int b){
        if (b == 0) {
            return a;
        }else {
            return Euclid(b,a%b);
        }
    }
}
