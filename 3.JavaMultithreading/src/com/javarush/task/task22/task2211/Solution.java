package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        byte[] buff = new byte[fileInputStream.available()];
        fileInputStream.read(buff);
        Charset ch1 = Charset.forName("Windows-1251");
        String s = new String(buff, ch1);
        Charset ch2 = Charset.forName("UTF-8");
        byte[] buff1 = s.getBytes(ch2);
        fileOutputStream.write(buff1);
    }
}
