package com.javarush.task.task20.task2025;

import javafx.print.Collation;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        SortedSet<Long> numberSet = new TreeSet<>();
        while (Long.parseLong(arrayDigitToString(tempDigit))<N){
            generateDigit(tempDigit.length-1);
            long sumPow=sumPow(tempDigit);
            if (isArmstrongDigit(sumPow)) {
                numberSet.add(sumPow);
            }
        }
        long[] result =new long[numberSet.size()];
        Iterator<Long> itr = numberSet.iterator();
        int i=0;
        while (itr.hasNext()){

            result[i]=itr.next();
            ++i;
        }
        return result;
    }

    static  int[] tempDigit=new int[19];

    static long[][]powTable;
    static {
        powTable = powTable();
        //tempDigit[tempDigit.length-1]=1;
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

    static int [] fragmentedNumber(Long numb){
        int []result=new int[countOfNumbers(numb)];
        for (int i = result.length-1; i >=0; i--) {
            result[i]=((int)(numb%10));
            numb/=10;
        }
        return result;
    }

    static boolean isArmstrongDigit(long numb) {
        boolean result = false;
        int[] arr = fragmentedNumber(numb);
        long l = sumPow(arr);
        if (numb == l) {
            result = true;
        }
        return result;
    }



    //----------------------------------------------------------------

   static void generateDigit(int x){
       if (x>0) {

           if (tempDigit[x] == 9) {
               tempDigit[x] = 0;
               generateDigit(x - 1);
           } else {
               tempDigit[x] = tempDigit[x] + 1;
           }
           /*if (tempDigit[x] == 0) {
               if (tempDigit[x-1] == 0) {
                   generateDigit(x-1);
               }else {
                   tempDigit[x]=tempDigit[x-1];
               }
           }*/
       }

   }



    static int pow(int[] mass){
        String str=arrayDigitToString(mass);
        int count = str.length();
        return count;
    }

    static String arrayDigitToString(int[] array){
        String s;
        return s=Arrays.toString(array).replaceAll("\\[|\\]|,|\\s", "").replaceFirst("^0+(?!$)", "");
    }

    static  long sumPow(int [] mass){
        int pow=pow(mass);
        int index=mass.length-pow;
        long result=0;
        for (int i = index; i <=mass.length-1 ; i++) {
            result+=powTable[mass[i]][pow];
        }
        return result;
    }

    public static void main(String[] args) {
       /* long[] armstrong=getNumbers(Long.MAX_VALUE);
        System.out.println(Arrays.toString(armstrong));*/

        for (int i = 0; i <1000 ; i++) {
            generateDigit(tempDigit.length-1);
            System.out.println(Arrays.toString(tempDigit)/*.replaceAll("\\[|\\]|,|\\s", "").replaceFirst("^0+(?!$)", "")*/);
        }

    }
}
