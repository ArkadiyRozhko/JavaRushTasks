package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thread5 implements Runnable {

    @Override
    public void run() {
        int summ=0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s="";
            while (!(s= reader.readLine()).equals("N")){
                summ+=Integer.parseInt(s);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(summ);
    }
}
