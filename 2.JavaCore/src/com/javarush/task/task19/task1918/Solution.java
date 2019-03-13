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
        ArrayList<String> list=tagList(result,args[0]);
        for (String s:list
             ) {
            System.out.println(s);
        }

    }
    public static ArrayList<String> tagList(String str, String tag){
        String beginTag="<"+tag;
        String endTag="</"+tag+">";
        ArrayList<String>strList=new ArrayList<>();
        String str1=str;
        //StringBuilder builder=new StringBuilder(str);
        while (!(str1.isEmpty())&&str1.indexOf(beginTag)!=-1){
            int firstIndex=str1.indexOf(beginTag);
            int endIndex=lastIndexOf(str1,tag);
            strList.add(str1.substring(firstIndex,endIndex));
            String temp;
            String temp1;

            if ((str1.charAt(firstIndex+beginTag.length()))=='>') {
                temp=str1.substring(firstIndex+beginTag.length()+1,endIndex-endTag.length());
            }else {
                temp = str1.substring(firstIndex + beginTag.length(), endIndex - endTag.length());
            }
            temp1=str1.substring(endIndex);
            str1=temp+temp1;


//            str1=str1.substring(firstIndex+beginTag.length())+str1.substring(0,endIndex-endTag.length())+str1.substring(endIndex);
//            String temp=str1.substring(0,endIndex-endTag.length());
//            String temp1=str1.substring(endIndex);
//            str1=temp+temp1;

        }
        return  strList;
    }
    public static int lastIndexOf(String str,String tag){
        int count=0;
        String beginTag="<"+tag;
        String endTag="</"+tag+">";

        int firstIndexOfTag=str.indexOf(beginTag);
        int lastIndexOffTag=str.indexOf(endTag);


        while (firstIndexOfTag<lastIndexOffTag&&str.indexOf(beginTag,firstIndexOfTag+1)!=-1){

                firstIndexOfTag=str.indexOf(beginTag,firstIndexOfTag+1);
            count++;
        }
        for (int i = count-1; i >0 ; i--) {
            lastIndexOffTag=str.indexOf(endTag,lastIndexOffTag+1);
        }
        return lastIndexOffTag+endTag.length();

    }
}
