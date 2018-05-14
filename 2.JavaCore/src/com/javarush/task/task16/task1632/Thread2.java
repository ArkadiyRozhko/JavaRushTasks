package com.javarush.task.task16.task1632;

public class Thread2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
