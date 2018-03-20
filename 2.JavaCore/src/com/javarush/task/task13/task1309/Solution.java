package com.javarush.task.task13.task1309;

/* 
Всё, что движется
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
    public interface Movable{
        public Double speed();
    }
    public interface Flyable extends Movable{
        public Double speed(Flyable fly);
    }

}