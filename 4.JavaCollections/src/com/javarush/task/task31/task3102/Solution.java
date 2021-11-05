package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File folder=new File(root);
        List<String>filePath=new ArrayList<>();
        Queue<File> fileQueue=new ArrayDeque<>();
        Collections.addAll(fileQueue, Objects.requireNonNull(folder.listFiles()));
        while (fileQueue.peek()!=null){
            File tmp=fileQueue.poll();
            if (tmp.isFile()) {
                filePath.add(tmp.getAbsolutePath());
            }else if (tmp.isDirectory()) {
                Collections.addAll(fileQueue, Objects.requireNonNull(tmp.listFiles()));
            }
        }
        return filePath;

    }

    public static void main(String[] args) {
        String root="D:\\E\\1\\3102";
        try {
            List<String> listFiles=getFileTree(root);
            for (String s:listFiles
                 ) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
