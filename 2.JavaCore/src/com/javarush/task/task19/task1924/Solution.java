package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String path=reader.readLine();
        reader.close();
        BufferedReader readerfile=new  BufferedReader(new FileReader(path));
        String line="";
        String[] words;
        while ((line=readerfile.readLine())!=null){
            words=line.split(" ");
            String result=" ";
            for (int i = 0; i < words.length ; i++) {
                try {
                    if(map.get(Integer.parseInt(words[i]))!=null){
                    result+=map.get(Integer.parseInt(words[i]))+" ";
                    }else throw new NumberFormatException();

                }catch (NumberFormatException e){
                    result+=words[i]+" ";
                }
            }
            System.out.println(result);
        }
        readerfile.close();

    }

}
