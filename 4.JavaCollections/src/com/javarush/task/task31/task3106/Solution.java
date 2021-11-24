package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
     String resultFileName=args[0];
        ArrayList<String> arhivPartPaths = new ArrayList<>(Arrays.asList(args).subList(1, args.length));
        List<FileInputStream>fisList=new ArrayList<>();
    Collections.sort(arhivPartPaths);
        for (String s:arhivPartPaths
             ) {
            fisList.add(new FileInputStream(s));
        }
        File resultFile=new File(resultFileName);

        try (ZipInputStream zipInputStream=new ZipInputStream(new SequenceInputStream(Collections.enumeration(fisList)));
        OutputStream outputStream =new BufferedOutputStream(new FileOutputStream(resultFile))){
            while (zipInputStream.getNextEntry()!=null){
                final int buffSize=1024;
                byte[]buffer= new byte[buffSize];
                int count;
                while ((count=zipInputStream.read(buffer))!=-1){
                    outputStream.write(buffer,0,count);
                }
                outputStream.flush();
            }
        }

    }
}
