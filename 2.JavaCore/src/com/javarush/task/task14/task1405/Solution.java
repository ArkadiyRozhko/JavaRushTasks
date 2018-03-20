package com.javarush.task.task14.task1405;

/* 
Food
*/

public class Solution {
    public static void main(String[] args) {
        Food food = new Food();
        Selectable selectable = new Food();
        Food newFood = (Food) selectable;

        foodMethods(food);
        selectableMethods(selectable);
    }

    public static void foodMethods(Food food) {
        food.onSelect();//тут добавьте вызов методов для переменной food
        food.eat();
    }

    public static void selectableMethods(Selectable selectable) {
        selectable.onSelect();//тут добавьте вызов методов для переменной selectable

    }

    interface Selectable {
        void onSelect();
    }

    static class Food implements Selectable {
        public void eat() {
            System.out.println("food was eaten");
        }

        @Override
        public void onSelect() {
            System.out.println("food was selected");
        }
    }
}
