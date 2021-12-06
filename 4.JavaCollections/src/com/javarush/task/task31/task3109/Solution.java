package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties;

        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            if (fileName.endsWith(".xml")) {
                properties=new Properties();
                properties.loadFromXML(inputStream);
            }else{
                properties=new Properties();
                properties.load(inputStream);
            }
            return properties;

        } catch (FileNotFoundException e) {
            properties=new Properties();
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
