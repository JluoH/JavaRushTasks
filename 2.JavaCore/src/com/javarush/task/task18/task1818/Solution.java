package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = bufferedReader.readLine();
        String f2 = bufferedReader.readLine();
        String f3 = bufferedReader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(f1, true);
        FileInputStream fileInputStream1 = new FileInputStream(f2);
        FileInputStream fileInputStream2 = new FileInputStream(f3);
        byte[] buff1 = new byte[fileInputStream1.available()];
        byte[] buff2 = new byte[fileInputStream2.available()];
        if (fileInputStream1.available() > 0 && fileInputStream2.available() > 0) {
            fileInputStream1.read(buff1);
            fileInputStream2.read(buff2);
            fileOutputStream.write(buff1);
            fileOutputStream.write(buff2);
        }
        bufferedReader.close();
        fileOutputStream.close();
        fileInputStream1.close();
        fileInputStream2.close();
    }
}
