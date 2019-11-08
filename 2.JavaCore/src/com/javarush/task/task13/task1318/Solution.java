package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        InputStream istr = new FileInputStream(buff.readLine());
        while (istr.available() > 0) {
            System.out.print((char)istr.read());
        }
        istr.close();
        buff.close();
    }
}