package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int summ=0;

            FileInputStream inputStream=new FileInputStream(args[0]);
            while (inputStream.available()>0){
                char symb =(char) inputStream.read();
                if ((symb>='a'&&symb<='z')||(symb>='A'&&symb<='Z')) {
                    summ++;
                }
            }
            inputStream.close();

        System.out.println(summ);
    }
}
