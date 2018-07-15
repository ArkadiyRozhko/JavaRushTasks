package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file;
        while (!(file=reader.readLine()).equals("exit")){
            ReadThread readThread=new ReadThread(file);
            readThread.start();
        }

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName=fileName;

        }

        @Override
        public void run() {
            try {
                resultMap.put(fileName,readFromFile(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
        int readFromFile(String file) throws IOException {
            byte[] bytes=new byte[255];
            FileInputStream inputStream=new FileInputStream(file);
            while (inputStream.available()>0){
                bytes[inputStream.read()]++;
            }

            int index=0;
            int max=bytes[index];
            for (int i = 0; i <bytes.length ; i++) {
                if (max<bytes[i]){
                    max=bytes[i];
                    index=i;
                }
            }
            inputStream.close();
            return index;
        }
    }
}
