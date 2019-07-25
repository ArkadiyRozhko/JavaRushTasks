package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long>numbers=new ArrayList<>();
        for (long i = 0; i <N ; i++) {
            if (i == checkNumber(countNumbers(i))) {
                numbers.add(i);
            }
        }
        long[] result = new long[numbers.size()];
        for (int i = 0; i <result.length ; i++) {
            result[i]=numbers.get(i);
        }
        return result;
    }
    public static ArrayList<Long> countNumbers(long N){
        ArrayList<Long>nums=new ArrayList<>();
        while (N!=0){
            nums.add(N%10);
            N/=10;
        }
        Collections.reverse(nums);
        return nums;
    }
    public static long checkNumber(ArrayList<Long> numb){
        int pow=numb.size();
        long result = 0;
        for (int i = 0; i < numb.size(); i++) {
            result+=Math.pow(numb.get(i),pow);
        }
        return result;
    }

    public static void main(String[] args) {
        long i=123411123;
        long[] numbers=getNumbers(i);
        for (long n:numbers
             ) {
            System.out.println(n);
        }
    }
}
