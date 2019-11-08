package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        int data;
        int count = 1;
        while (fileReader.ready()) {
            data = fileReader.read();
            if (count % 2 == 0) {
                fileWriter.write(data);
            }
            count++;
        }
        bufferedReader.close();
        fileReader.close();
        fileWriter.close();
    }
}
