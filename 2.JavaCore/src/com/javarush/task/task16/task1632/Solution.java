package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        Thread it = new Thread(new Thread1());
        Thread inth = new Thread(new Thread2());
        Thread ut = new Thread(new Thread3());
        Thread mt=new Thread4();
        Thread st = new Thread(new Thread5());
        threads.add(it);
        threads.add(inth);
        threads.add(ut);
        threads.add(mt);
        threads.add(st);

    }

    public static void main(String[] args) {
        for (Thread t:threads
             ) {
            t.start();
        }
        threads.get(1).interrupt();


    }
}