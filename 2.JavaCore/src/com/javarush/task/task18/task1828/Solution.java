package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String filePath=reader.readLine();
        if (args.length==5&&args[0].equals("-u")){
            Update(args,filePath);
        }else if (args.length==2&&args[0].equals("-d")){
            Delete(args,filePath);
        }

    }
    public static void Delete(String[] arguments,String path){
        ArrayList<String>listString=ReadFromFile(path);
        for (String str:listString
             ) {
            if (str.startsWith(arguments[1])) {
                listString.remove(str);
                break;
            }
        }
        WriteToFile(listString,path);


    }
    public static void Update(String[] arguments,String path){
        ArrayList<String>listString=ReadFromFile(path);
        ListIterator<String>listIterator=listString.listIterator();
        while (listIterator.hasNext()){
            if (arguments[1].equals(listIterator.next().substring(0,8).trim())) {
                String tmp=productStr(arguments);
                listIterator.set(tmp);
            }
        }
        WriteToFile(listString,path);

    }
    public static ArrayList<String> ReadFromFile(String path){
        ArrayList<String>lines=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new FileReader(path))){
            String str;
            while ((str=reader.readLine())!=null){
                lines.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    static String productStr(String[] arguments){
        String Id=arguments[1];
        String productName = arguments[2];
        String price = arguments[3];
        String quantity = arguments[4];
        int countSpaceId=8-Id.length();
        for (int i = 0; i <countSpaceId; i++) {
            Id=Id+" ";
        }
        int countSpaceProduct=30-productName.length();
        for (int i = 0; i <countSpaceProduct; i++) {
            productName=productName+" ";
        }
        int countSpacePrice=8-price.length();
        for (int i = 0; i < countSpacePrice; i++) {
            price=price+" ";
        }
        int countSpaceQuantity=4-quantity.length();
        for (int i = 0; i < countSpaceQuantity; i++) {
            quantity=quantity+" ";
        }
        String result=Id+productName+price+quantity;
        return result;

    }
    public static void WriteToFile(ArrayList<String> strings, String path){
        String str="";
        for (String item:strings
             ) {
            str+=(item+"\r\n");
        }
        try (BufferedWriter writer=new BufferedWriter(new FileWriter(path))){
            writer.write(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
