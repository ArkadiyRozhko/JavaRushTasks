package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        if (args.length==4&&args[0].equals("-c")) {
            int id = getId(fileName)+1;
            try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName,true))) {
                String resultString=productStr(id,args);
                if (id==1){
                    writer.write(resultString);
                }else {
                writer.write("\r\n"+resultString);
                }
                writer.flush();
            }
        }
    }
    static int getId(String filePath){
        int maxId=0;
        try(BufferedReader reader=new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str=reader.readLine())!=null){
                int id = Integer.parseInt(str.substring(0, 8).trim());
                if (id >maxId) {
                    maxId=id;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId;
    }
    static String productStr(int id, String[] arguments){
        String stringId=Integer.toString(id);
        String productName = arguments[1];
        String price = arguments[2];
        String quantity = arguments[3];
        int countSpaceId=8-stringId.length();
        for (int i = 0; i <countSpaceId; i++) {
            stringId=stringId+" ";
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
        String result=stringId+productName+price+quantity;
        return result;

    }
}
