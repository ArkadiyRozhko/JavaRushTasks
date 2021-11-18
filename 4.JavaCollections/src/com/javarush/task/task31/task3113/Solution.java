package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path path;
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))){
            path=Paths.get(bufferedReader.readLine());
        }
        if (!Files.isDirectory(path)) {
            System.out.println(path.toString()+" - не папка");
        }else {
            PropertyVisitor propertyVisitor = new PropertyVisitor();
            Files.walkFileTree(path, propertyVisitor);
            System.out.println("Всего папок - " + propertyVisitor.getCountOfDirectory().decrementAndGet());
            System.out.println("Всего файлов - " + propertyVisitor.getCountOfFiles());
            System.out.println("Общий размер - " + propertyVisitor.getAllSize());
        }

    }

}
class PropertyVisitor extends SimpleFileVisitor<Path>{

        private AtomicInteger countOfDirectory=new AtomicInteger(0);
        private AtomicInteger countOfFiles=new AtomicInteger(0);
        private AtomicLong allSize=new AtomicLong(0);

    public AtomicInteger getCountOfDirectory() {
        return countOfDirectory;
    }

    public AtomicInteger getCountOfFiles() {
        return countOfFiles;
    }

    public AtomicLong getAllSize() {
        return allSize;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory(dir)) {
            countOfDirectory.incrementAndGet();
        }
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            if (attrs.isRegularFile()) {
                countOfFiles.incrementAndGet();
                allSize.addAndGet(attrs.size());
            }

            return super.visitFile(file, attrs);
        }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return FileVisitResult.SKIP_SUBTREE;
    }
}





