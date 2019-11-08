package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();
        String s = "";
        while (bufferedReader1.ready()) {
            s += bufferedReader1.readLine();
        }
        bufferedReader1.close();
        bufferedWriter.write(s.replaceAll("[\\W&&[^\\s]]", ""));
        bufferedWriter.close();
    }
}
