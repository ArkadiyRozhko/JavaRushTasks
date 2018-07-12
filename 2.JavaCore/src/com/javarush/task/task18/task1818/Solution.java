package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        String thirdFile = reader.readLine();

        FileOutputStream outputStream = new FileOutputStream(firstFile);
        FileInputStream inputStream=new FileInputStream(secondFile);
        FileInputStream inputStream1=new FileInputStream(thirdFile);

        while (inputStream.available()>0){
            outputStream.write(inputStream.read());
        }
        while (inputStream1.available()>0){
            outputStream.write(inputStream1.read());
        }
        outputStream.close();
        inputStream.close();
        inputStream1.close();



    }
}
