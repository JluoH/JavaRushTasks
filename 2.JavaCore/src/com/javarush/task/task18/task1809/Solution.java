package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());
        bufferedReader.close();
        if (fileInputStream.available() > 0) {
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            byte[] bytes1 = new byte[bytes.length];
            int x = 0;
            for (int i = bytes.length - 1; i >= 0; i--) {
                bytes1[x] = bytes[i];
                x++;
            }
            fileOutputStream.write(bytes1, 0, bytes1.length);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
