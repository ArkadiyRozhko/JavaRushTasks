package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        path=reader.readLine();
        reader.close();
        BufferedReader readFile=new BufferedReader(new FileReader(path));
        String line;
        while ((line=readFile.readLine())!=null){
            String reverse=new StringBuffer(line).reverse().toString();
            System.out.println(reverse);
        }
        readFile.close();

    }
}
