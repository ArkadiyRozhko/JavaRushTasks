package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;


public class FileUtils {

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void renameFile(File source, File destination) {
        if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
    }

    public static boolean isExist(File file) {
        return file.exists();
    }




}
