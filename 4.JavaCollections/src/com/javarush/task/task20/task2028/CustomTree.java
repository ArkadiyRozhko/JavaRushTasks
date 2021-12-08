package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable,Serializable {
    String value;
    CustomTree left;
    CustomTree right;

    public CustomTree() {
        this.value = "0";
        left=null;
        right=null;
    }

    @Override
    public boolean add(String s) {
        return super.add(s);
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
