package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        boolean flag=true;
        while (flag){
            String fileName= null;
            try {
                fileName = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try(FileInputStream inputStream=new FileInputStream(fileName)) {


            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                flag=false;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
