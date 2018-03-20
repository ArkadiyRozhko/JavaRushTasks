package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        double result=0;
        int number=0;
        int count=0;
        boolean flag=true;
        while ( flag)
        {
            number = Integer.parseInt(reader.readLine());
            if (number!=-1){
                result+=number;
                count++;
            }
            else
            flag=false;

        }

        result=result/count;
        System.out.println(result);
    }
}

