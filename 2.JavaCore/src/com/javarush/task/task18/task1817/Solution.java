package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int x;
        int count = 0;
        int y = fileInputStream.available();
        while (fileInputStream.available()>0){
          x = fileInputStream.read();
          if (x==' ') count++;
        }
        System.out.println((Math.round((double)count/y*10000.0))/100.0);
        fileInputStream.close();
    }
}
