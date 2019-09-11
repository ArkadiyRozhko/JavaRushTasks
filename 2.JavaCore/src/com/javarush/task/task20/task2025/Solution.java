package com.javarush.task.task20.task2025;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        return result;
    }
    static long[][]powTable;
    static {
        powTable = powTable();
    }

    static long[][]powTable(){
        int numb=9;
        int pow=countOfNumbers(Long.MAX_VALUE);
        long [][]result=new long[numb+1][pow+1];
        for (int i = 0; i <=numb ; i++) {
            for (int j = 0; j <=pow; j++) {
                result[i][j]=(long) Math.pow(i,j);
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
        while (numb>0){
            result.add((int)(numb%10));
            numb/=10;
        }

        Collections.reverse(result);
        return result;
    }
    static ArrayList<Long> sumPow(long numb){
       // long[][]powTable=powTable();
        ArrayList<Long>result=new ArrayList<>();
        for (long i = 1; i <numb ; i++) {
            if (isUniqueDigit(i)) {
                System.out.println(i);
                int power=countOfNumbers(i);
                ArrayList<Integer>numbers=fragmentedNumber(i);
                long powerSum=0;
                for (int j = 0; j <numbers.size() ; j++) {
                    powerSum+=powTable[numbers.get(j)][power];
                }

                    result.add(powerSum);
            }

        }

        return result;
    }
    static boolean isUniqueDigit(long numb){
        ArrayList<Integer> numbers=fragmentedNumber(numb);
        for (int i = 0; i <numbers.size()-1 ; i++) {
            if (numbers.get(i)>numbers.get(i+1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

//        System.out.println(countOfNumbers(125));
//        long[][]tmp=powTable();
//        for (int i = 0; i <tmp.length ; i++) {
//            for (int j = 0; j <tmp[i].length ; j++) {
//                System.out.print(tmp[i][j]+"  ");
//            }
//            System.out.println();
//        }
//
//        for (Integer i:fragmentedNumber(100l)
//             ) {
//            System.out.print(i);
//        }
        long startTime=System.currentTimeMillis();
        ArrayList<Long>test=sumPow(Long.MAX_VALUE);
        long timeSpent=System.currentTimeMillis()-startTime;
        System.out.println(timeSpent/1000);
        System.out.println("--------------------------------------------------");
        for (Long item:test
             ) {
            System.out.println(item);
        }




    }
}
