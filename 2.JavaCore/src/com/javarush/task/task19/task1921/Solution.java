package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try(BufferedReader reader=new BufferedReader(new FileReader(args[0]))) {
            String line;
            String name;
            Date birthDate;
            String[]strings;
            while ((line=reader.readLine())!=null){
                strings=line.split(" ");
                for (int i=0;i<strings.length;i++){
                    if (isDigit(strings[i])) {

                    }
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
