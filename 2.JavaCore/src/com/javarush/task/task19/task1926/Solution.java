package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(bufferedReader.readLine()));
        while (fr.ready()){
            StringBuffer stringBuffer = new StringBuffer(fr.readLine());
            System.out.println(stringBuffer.reverse());
        }
        bufferedReader.close();
        fr.close();
    }
}
