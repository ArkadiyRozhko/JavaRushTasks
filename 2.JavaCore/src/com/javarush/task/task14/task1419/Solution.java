package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] mass = new int[2];
            mass[3] = 5;
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            Integer.parseInt("asdsfa");
        }catch (Exception e){
            exceptions.add(e);
        }
        try{
            Object x[]=new String[3];
            x[0]=new Integer(0);
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            Object x=new Integer(0);
            System.out.println((String) x);
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            int x = -1;
            int[]mass=new int[x];
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            String car = "ford";
            char c = car.charAt(4);
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new FileNotFoundException();
            /*String path = "d:/1.db";
            FileWriter writer=new FileWriter(path);*/
        } catch (IOException e) {
            exceptions.add(e);
        }
        try {
            throw new NullPointerException();
            /*Integer x=null;
            Math.sqrt((double)x);*/
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new IllegalArgumentException();
        }catch (Exception e){
            exceptions.add(e);
        }
        //напишите тут ваш код

    }
}
