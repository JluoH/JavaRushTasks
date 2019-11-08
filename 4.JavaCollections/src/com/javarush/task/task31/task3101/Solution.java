package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException, InterruptedException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        ArrayList<File> list = new ArrayList<>();
        File[] mass = path.listFiles();
        list = allFiles(mass, list);
        ArrayList<String> list2 = new ArrayList<>();
        for (File file : list) {
            list2.add(file.getName());
        }
        Collections.sort(list2);
        ArrayList<File> list3 = new ArrayList<>();
        for (String s : list2) {
            for (File file : list) {
                if (s.equals(file.getName())) {
                    list3.add(file);
                    break;
                }
            }
        }
        File fileall = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt");

            FileUtils.renameFile(resultFileAbsolutePath, fileall);

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileall))
        ) {
            for (File file1 : list3) {
                BufferedReader reader = new BufferedReader(new FileReader(file1));
                while (reader.ready()) {
                    writer.write(reader.readLine());
                }
                writer.write("\n");
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ArrayList allFiles(File[] mass, ArrayList<File> list) {
        for (File file : mass) {
            if (file.isFile()) {
                if (file.length() <= 50) {
                    list.add(file);
                }
            } else if (file.isDirectory()) {
                allFiles(file.listFiles(), list);
            }
        }
        return list;
    }
}
