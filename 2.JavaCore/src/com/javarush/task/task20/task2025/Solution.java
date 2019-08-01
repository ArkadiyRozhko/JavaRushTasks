package com.javarush.task.task20.task2025;

import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        return result;
    }
    static long[][]powTable(){
        int numb=9;
        int pow=countOfNumbers(Long.MAX_VALUE);
        long [][]result=new long[numb][pow];
        for (int i = 1; i <numb+1 ; i++) {
            for (int j = 1; j <pow+1; j++) {
                result[i-1][j-1]=(long) Math.pow(i,j);
            }
        }
        return result;
    }
    static int countOfNumbers(long numb){
        int result=Long.toString(numb).length();
        return result;
    }
    static ArrayList<Integer> fragmentedNumber(Long numb){
        ArrayList<Integer>result=new ArrayList<>();
        int tmp;
        while ()
    }

    public static void main(String[] args) {

        System.out.println(countOfNumbers(1));
        long[][]tmp=powTable();
        for (int i = 0; i <tmp.length ; i++) {
            for (int j = 0; j <tmp[i].length ; j++) {
                System.out.println(tmp[i][j]);
            }
        }


    }
}
