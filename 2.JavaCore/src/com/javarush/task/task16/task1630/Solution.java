package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            secondFileName=reader.readLine();
        } catch (IOException e) {


        }
    }


    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String fileName;
        String fileContent="";
        @Override
        public void setFileName(String fullFileName) {
            fileName=fullFileName;
        }

        @Override
        public String getFileContent() {
            return this.fileContent;
        }

        @Override
        public void run() {

            try (BufferedReader br=new BufferedReader(new FileReader(fileName))){
                String s;
                while ((s=br.readLine())!=null){
                    fileContent+=s+" ";
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
