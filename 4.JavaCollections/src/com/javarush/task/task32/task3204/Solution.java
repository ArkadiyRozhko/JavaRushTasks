package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            String password = getPassword().toString();
//            if (password.equals(password.toLowerCase())) {
//                System.out.printf("LowerCase - %s\n", password);
//            } else if (password.equals(password.toUpperCase())) {
//                System.out.printf("UpperCase - %s\n", password);
//            } else if (noNumbers(password)) {
//                System.out.printf("No Number - %s\n", password);
//            }
//        }
//    }
//
//    private static boolean noNumbers(String string) {
//        for (char ch : string.toCharArray()) {
//            if (Character.isDigit(ch)) {
//                return false;
//            }
//        }
//        return true;





        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        boolean hasDigit=false;
        boolean hasLowLeter=false;
        boolean hasBigLeter=false;
        ByteArrayOutputStream result=new ByteArrayOutputStream(8);

        while ((!hasDigit)|(!hasLowLeter)|(!hasBigLeter)) {
            hasDigit=false;
            hasLowLeter=false;
            hasBigLeter=false;
            result=generatePass();
            byte[] array = result.toByteArray();
            for (int i = 0; i < array.length; i++) {
               // char temp = (char) array[i];
                if (array[i]>=48&&array[i]<=57) {
                hasDigit=true;
                continue;
                }
                if (array[i]>=97&&array[i]<=122) {
                    hasLowLeter=true;
                continue;
                }
                if (array[i]>=65&&array[i]<=90) {
                    hasBigLeter=true;
                continue;
                }
            }
        }

        return result;
    }

    public static ByteArrayOutputStream generatePass(){

        final String alfabet="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random=new Random();

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream(8);
        for (int i = 0; i < 8; i++) {
            char temp=alfabet.charAt(random.nextInt(alfabet.length()));
            outputStream.write(temp);
        }

        return outputStream;
    }
}
