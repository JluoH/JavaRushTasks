package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();
        String s = "";
        while (fileReader.ready()) {
            s += (char) fileReader.read();
        }
        fileReader.close();
        String h  = s.replaceAll("\\bworld\\b", "");
        System.out.println((s.length()-h.length())/5);
    }
}
