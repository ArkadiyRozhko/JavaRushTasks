package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1=args[0];
        String file2=args[1];
        try (BufferedReader reader=new BufferedReader(new FileReader(file1));
             BufferedWriter writer=new BufferedWriter(new FileWriter(file2))){
            String line="";
            String[]words;
            String result = "";
            while ((line=reader.readLine())!=null){
                words=line.split(" ");
                for (int i = 0; i <words.length ; i++) {
                    if (words[i].length()>6) {
                        result+=words[i]+" ";
                    }
                }
            }
            String stringForWrite=result.trim();
            writer.write(stringForWrite.replace(" ",","));
        }

    }
}
