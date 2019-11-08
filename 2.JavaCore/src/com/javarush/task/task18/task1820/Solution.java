package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());
        String s = "";
        while (fileInputStream.available() > 0) {
            s += (char) fileInputStream.read();
        }
        String[] mass = s.split(" ");
        String j = "";
        for (int i = 0; i < mass.length; i++) {
            j += Math.round(Double.parseDouble(mass[i])) + " ";
        }
        byte[] b = j.getBytes();
        fileOutputStream.write(b);
        bufferedReader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
