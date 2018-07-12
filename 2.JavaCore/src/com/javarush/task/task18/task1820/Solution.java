package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        FileInputStream inputStream=new FileInputStream(file1);
        FileOutputStream outputStream=new FileOutputStream(file2);
        ArrayList<String>strings=new ArrayList<>();
        String st="";

        while (inputStream.available()>0){
            int tmp=inputStream.read();
                char symb = (char)tmp;
                st=st+symb;
            if (tmp == 32||inputStream.available()==0){
                strings.add(st);
                st="";
            }
        }
        for (String s:strings
             ) {
            int rez=(int)Math.round(Double.parseDouble(s));
            String str = Integer.toString(rez);
            byte[]bytes=str.getBytes();
            for (int i = 0; i <bytes.length ; i++) {
                outputStream.write(bytes[i]);
            }
           outputStream.write(32);
        }
        inputStream.close();
        outputStream.close();

    }
}
