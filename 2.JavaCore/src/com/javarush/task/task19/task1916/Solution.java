package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        reader.close();
        FileReader fileReader1=new FileReader(file1);
        FileReader fileReader2=new FileReader(file2);

        ArrayList<String>stringFile1=new ArrayList<>();
        ArrayList<String>stringFile2=new ArrayList<>();

        try(BufferedReader readerFile1=new BufferedReader(fileReader1))
        {
            String s;
            while ((s=readerFile1.readLine())!=null){
                stringFile1.add(s);
            }
        }
        try(BufferedReader readerFile2=new BufferedReader(fileReader2))
        {
            String s;
            while ((s=readerFile2.readLine())!=null){
                stringFile2.add(s);
            }
        }
        fileReader1.close();
        fileReader2.close();


        for (int i = 0,j=0; i <stringFile1.size();i++) {
            if (stringFile1.get(i).equals(stringFile2.get(i))) {
                lines.add(new LineItem(Type.SAME,stringFile1.get(i)));
                j++;
            }else if (stringFile1.get(i).equals(stringFile2.get(i+1))) {
                lines.add(new LineItem(Type.ADDED,stringFile2.get(i)));
            }else if (stringFile2.get(j).equals(stringFile1.get(i+1))){
                lines.add(new LineItem(Type.REMOVED,stringFile1.get(i)));
                j++;
            }
        }
        for (LineItem item:lines
             ) {
            System.out.println(item.type+" "+item.line);
        }


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
