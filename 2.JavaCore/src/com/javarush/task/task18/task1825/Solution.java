package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;/*
Собираем файл
*/
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while (!(s = bufferedReader.readLine()).equals("end")) {
            list.add(s);
        }
        if (!list.isEmpty()) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(list.get(0).split(".part")[0]), true);
            Collections.sort(list);
            ArrayList<byte[]> list1 = new ArrayList<>();
            for (String s1 : list) {
                FileInputStream fileInputStream = new FileInputStream(s1);
                if (fileInputStream.available() > 0) {
                    byte[] bytes = new byte[fileInputStream.available()];
                    fileInputStream.read(bytes);
                    list1.add(bytes);
                }
                fileInputStream.close();
            }
            for (byte[] bytes : list1) {
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();
        }
    }
}
