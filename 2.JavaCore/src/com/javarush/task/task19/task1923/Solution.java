package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1=args[0];
        String file2=args[1];

        try(BufferedReader reader=new BufferedReader(new FileReader(file1));
            BufferedWriter writer=new BufferedWriter(new FileWriter(file2))){
            String line;
            String[] lineWords;
            while ((line=reader.readLine())!=null){
                lineWords=line.split(" ");

            }
        }

    }

}
