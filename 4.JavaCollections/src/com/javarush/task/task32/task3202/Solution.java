package com.javarush.task.task32.task3202;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\Users\\evilr\\3D Objects\\Desktop\\a.TXT"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if (is == null) {
            return sw;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (reader.ready()) {
            sw.write(reader.read());
        }
        return sw;
    }
}