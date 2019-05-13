package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try(BufferedReader reader=new BufferedReader(new FileReader(args[0]))) {
            String line;
            String[]strings;
            while ((line=reader.readLine())!=null){
                if (!line.isEmpty()) {

                    strings = line.split(" ");

                    String name = "";
                    int day = 0, month = 0, year = 0;
                    int count = 0;

                    for (int i = 0; i < strings.length; i++) {
                        if (isDigit(strings[i])) {
                            if (count == 0) {
                                day = Integer.parseInt(strings[i]);
                            }
                            if (count == 1) {
                                month = Integer.parseInt(strings[i]);
                            }
                            if (count == 2) {
                                year = Integer.parseInt(strings[i]);
                            }
                            count++;
                        } else {
                            name += strings[i] + " ";
                            name=name.trim();
                        }
                    }
                    Calendar calendar = new GregorianCalendar(year, month-1, day);
                    Person p = new Person(name, calendar.getTime());
                    PEOPLE.add(p);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static boolean isDigit(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
