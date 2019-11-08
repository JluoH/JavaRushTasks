package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Минимальный байт
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            arrayList.add(fileInputStream.read());
        }
        System.out.println(Collections.min(arrayList));
        bufferedReader.close();
        fileInputStream.close();
    }
}
