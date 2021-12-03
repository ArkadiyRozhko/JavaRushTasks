package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
      Path path=Paths.get(pathToFile);
        try {
            fileData=new ConcreteFileData(Files.isHidden(path),Files.isExecutable(path),Files.isDirectory(path),Files.isWritable(path));
        } catch (IOException e) {
            fileData=new NullFileData(e);
        }

    }

    public FileData getFileData() {
        return fileData;
    }
}
