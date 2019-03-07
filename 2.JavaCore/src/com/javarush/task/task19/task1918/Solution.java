package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String filePath=reader.readLine();
        reader.close();
        String result="";
        try (FileReader fileReader=new FileReader(filePath)){
            int c;
            while ((c=fileReader.read())!=-1){
                result+=(char)c;
            }
        }
        tagList(result,args[0]);
        System.out.println(result);

    }
    public static ArrayList<String> tagList(String str, String tag){
        String beginTag="<"+tag;
        String endTag="</"+tag+">";
        ArrayList<String>strList=new ArrayList<>();
        StringBuilder builder=new StringBuilder(str);
        while (!(builder.toString().isEmpty())){
            int firstIndex=builder.indexOf(beginTag);
            int endIndex=lastIndexOf(builder.toString(),endTag);
            strList.add(builder.toString().substring(firstIndex,endIndex));
            builder.substring(endIndex);
        }
        return  strList;
    }
    public static int lastIndexOf(String str,String tag){
        int count=0;
        String beginTag="<"+tag;
        String endTag="</"+tag+">";

        int lastIndexOffTag=str.indexOf(endTag);

    }
}
