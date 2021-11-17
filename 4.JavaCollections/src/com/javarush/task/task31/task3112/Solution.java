package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/E/1/3112"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url= new URL(urlString);
        InputStream inputStream=url.openStream();
        String[] pathElement=urlString.split("/");
        Path tempFile = Files.createTempFile(pathElement[pathElement.length-1],".tmp");
        Files.copy(inputStream,tempFile,StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();

        return Files.move(tempFile,downloadDirectory.resolve(pathElement[pathElement.length-1]),StandardCopyOption.REPLACE_EXISTING);
        // implement this method
    }
}
