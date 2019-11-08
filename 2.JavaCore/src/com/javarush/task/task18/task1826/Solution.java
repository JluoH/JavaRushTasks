package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        String a1 = args[1];
        String a2 = args[2];
        FileInputStream fileInputStream = new FileInputStream(a1);
        FileOutputStream fileOutputStream = new FileOutputStream(a2);
        switch (args[0]) {
            case ("-e"):
                int x;
                while (fileInputStream.available() > 0) {
                    x = fileInputStream.read();
                    fileOutputStream.write(++x);
                }
                break;
            case ("-d"):
                int y;
                while (fileInputStream.available() > 0) {
                    y = fileInputStream.read();
                    fileOutputStream.write(--y);
                }
                break;
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
