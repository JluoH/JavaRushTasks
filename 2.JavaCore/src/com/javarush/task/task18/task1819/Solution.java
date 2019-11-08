package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(bufferedReader.readLine());
        FileInputStream fileInputStream2 = new FileInputStream(s);
        byte buff1[] = new byte[fileInputStream1.available()];
        byte buff2[] = new byte[fileInputStream2.available()];
        if (fileInputStream2.available() > 0) {
            fileInputStream2.read(buff2);
        }
        if (fileInputStream1.available() > 0) {
            fileInputStream1.read(buff1);
        }
        byte[] buff3 = new byte[buff1.length + buff2.length];
        System.arraycopy(buff1, 0, buff3, 0, buff1.length);
        System.arraycopy(buff2, 0, buff3, buff1.length, buff2.length);
        FileOutputStream fileOutputStream = new FileOutputStream(s);
        fileOutputStream.write(buff3);



        bufferedReader.close();
        fileOutputStream.close();
        fileInputStream1.close();
        fileInputStream2.close();
    }
}
