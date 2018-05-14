package com.javarush.task.task16.task1632;

public class Thread4 extends Thread implements Message {
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
        }
    }

    public void showWarning() {
        interrupt();
    }
}
