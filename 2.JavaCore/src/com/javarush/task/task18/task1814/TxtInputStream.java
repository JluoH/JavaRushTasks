package com.javarush.task.task18.task1814;

import java.io.*;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String s = fileName.substring(fileName.length() - 4);
        if (!s.equals(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TxtInputStream txtInputStream = new TxtInputStream(bufferedReader.readLine());
        System.out.println(txtInputStream.read());
    }
}

