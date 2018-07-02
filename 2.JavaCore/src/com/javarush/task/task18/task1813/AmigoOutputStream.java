package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream fos;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        fos=fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        fos.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fos.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        String st="JavaRush © All rights reserved.";
        write(st.getBytes());
        fos.close();
    }

    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
