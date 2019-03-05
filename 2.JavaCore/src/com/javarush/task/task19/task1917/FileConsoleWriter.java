package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter{
   private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
       this.fileWriter=new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter=new FileWriter(fileName,append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter=new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter=new FileWriter(file,append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter=new FileWriter(fd);
    }
    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf,off,len);
        for (int i = off; i <off+len ; i++) {
            System.out.print(cbuf[i]);
        }
    }
    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.print(c);
    }
    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.print(str);
    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str,off,len);
        System.out.print(str.substring(off,off+len));

    }
    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        for (int i = 0; i <cbuf.length ; i++) {
            System.out.print(cbuf[i]);
        }
    }
    public void close() throws IOException{
        fileWriter.close();
    }



    public static void main(String[] args) {

    }

}
