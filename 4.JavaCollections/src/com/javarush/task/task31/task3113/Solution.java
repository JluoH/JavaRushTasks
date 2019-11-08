package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static int vpap = -1;
    public static int vfai = 0;
    public static int obsraz = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
        } else {
            Files.walkFileTree(path, new Visitor());
            System.out.println("Всего папок - " + vpap);
            System.out.println("Всего файлов - " + vfai);
            System.out.println("Общий размер - " + obsraz);
        }
    }
}

class Visitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Solution.obsraz += Files.size(file);
        Solution.vfai++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Solution.vpap++;
        return FileVisitResult.CONTINUE;
    }
}
