package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));
        bufferedReader.close();
        String s;
        while ((s = reader.readLine()) != null) {
            if (s.startsWith(args[0] + "")) System.out.print(s);
        }
        reader.close();
    }
}
