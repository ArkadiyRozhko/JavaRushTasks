package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

import java.lang.reflect.Type;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result=new byte[ip.length];
        for (int i = 0; i < ip.length; i++) {
            result[i]=(byte)(ip[i]&mask[i]);
        }
        return result;
    }

    public static void print(byte[] bytes) {
        //System.out.println(bytes.length);
        for (byte b:bytes
             ) {

            int i = Byte.toUnsignedInt(b);
            System.out.print(String.format("%8s",Integer.toBinaryString(i)).replaceAll(" ","0"));
            System.out.print(" ");
        }
        System.out.println();

    }
}
