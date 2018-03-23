package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int one,two;

            one = Integer.parseInt(reader.readLine());
            two = Integer.parseInt(reader.readLine());
            if (one <= 0 || two <= 0) {
                throw new Exception();
            }else {
                System.out.println(Euclid(one,two));
            }

    }
    static int Euclid(int a, int b){
        if (b == 0) {
            return a;
        }else {
            return Euclid(b,a%b);
        }
    }
}
