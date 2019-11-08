package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {

    public static List<String> words = new ArrayList<String>();

    static {
        words.add("a");
        words.add("b");
        words.add("c");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String s;
        int count = 0;
        while (fr.ready()) {
            s = fr.readLine();
            for (String word : words) {
                if (Pattern.compile("\\b" + word + "\\b").matcher(s).find()) count++;
            }
            if (count == 2) {
                System.out.println(s);
            }
            count = 0;
        }
        fr.close();
    }
}
