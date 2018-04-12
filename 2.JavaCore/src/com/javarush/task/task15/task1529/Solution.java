package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = reader.readLine();
            if (str.equals("helicopter")){
                result=new Helicopter();
            }else if (str.equals("plane")){
                int passcount=Integer.parseInt(reader.readLine());
                result=new Plane(passcount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
