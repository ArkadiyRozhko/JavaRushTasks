package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
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

        lines=marge(stringFile1,stringFile2);
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
    public static List<LineItem> marge(ArrayList<String> stringsOriginFile,ArrayList<String>stringsChangedFile){
        ArrayList<String>list1=new ArrayList<>(stringsOriginFile);
        ArrayList<String>list2=new ArrayList<>(stringsChangedFile);
        List<LineItem>margeStrings=new ArrayList<>();
        while (!(list1.isEmpty()&&list2.isEmpty())){
            if (list1.isEmpty()) {
                margeStrings.add(new LineItem(Type.ADDED,list2.get(0)));
                break;
            }else if (list2.isEmpty()){
                margeStrings.add(new LineItem(Type.REMOVED,list1.get(0)));
                break;
            }

            if (list1.get(0).equals(list2.get(0))) {
                margeStrings.add(new LineItem(Type.SAME,list1.remove(0)));
                list2.remove(0);
            }else if (list1.get(0).equals(list2.get(1))) {
                margeStrings.add(new LineItem(Type.ADDED,list2.remove(0)));
            }else if (list2.get(0).equals(list1.get(1))) {
                margeStrings.add(new LineItem(Type.REMOVED,list1.remove(0)));
            }
        }
        return margeStrings;
    }
}
