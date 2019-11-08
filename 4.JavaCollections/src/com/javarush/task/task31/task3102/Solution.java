package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<File> list = new ArrayList();
        File file = new File(root);
        File[] mass = file.listFiles();
        Collections.addAll(list, mass);
        ArrayList<String> kek = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).isFile()) {
                kek.add(list.get(i).getAbsolutePath());
            } else if (list.get(i).isDirectory()) {
                File[] f = list.get(i).listFiles();
                Collections.addAll(list, f);
            }
            i++;
        }
        return kek;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> kek = new ArrayList();
        kek = (ArrayList<String>) getFileTree("C:\\Users\\evilr\\3D Objects\\Desktop\\heah");
        for (String s : kek) {
            System.out.println(s);
        }
    }
}
