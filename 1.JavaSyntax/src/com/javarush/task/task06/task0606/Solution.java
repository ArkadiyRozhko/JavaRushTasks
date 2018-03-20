package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void IsEven(int num){
        if (num%2==0)
            even+=1;
        else
            odd+=1;
    }

    public static int getCountofDigit(long numb){
        int count = (numb==0)?1:0;
        while (numb!=0){
            count++;
            numb/=10;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int count = getCountofDigit(number);
        for (int i = 0; i < count; i++) {
            IsEven(number%10);
            number/=10;
        }
        System.out.println("Even: "+even+" "+"Odd: "+odd );

    }
}
