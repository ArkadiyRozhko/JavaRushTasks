package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md_5= MessageDigest.getInstance("MD5");
        md_5.update(byteArrayOutputStream.toByteArray());
        byte[] array=md_5.digest();

        StringBuffer hexString = new StringBuffer();

        for (int i = 0;i<array.length;i++) {
            hexString.append(Integer.toHexString(0xFF & array[i]).length()<2?"0"+Integer.toHexString(0xFF & array[i]):Integer.toHexString(0xFF & array[i]));

        }
        String result=hexString.toString();
        System.out.println(result);

        return result.equals(md5);
    }
}
