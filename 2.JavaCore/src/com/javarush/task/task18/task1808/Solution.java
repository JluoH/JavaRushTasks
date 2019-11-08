package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = bufferedReader.readLine();
        String f2 = bufferedReader.readLine();
        String f3 = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(f1);
        FileOutputStream fileOutputStream = new FileOutputStream(f2);
        FileOutputStream fileOutputStream1 = new FileOutputStream(f3);
        if (fileInputStream.available() > 0) {
            byte[] bytes = new byte[fileInputStream.available()];
            int x = fileInputStream.available() / 2;
            int y = fileInputStream.available() - x;
            fileInputStream.read(bytes);
            fileOutputStream.write(bytes, 0, y);
            fileOutputStream1.write(bytes, y, x);
        }
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream1.close();
    }
}
