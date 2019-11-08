package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Максимальный байт
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(bufferedReader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available() > 0) {
            list.add(fis.read());
        }
        bufferedReader.close();
        fis.close();
        System.out.println(Collections.max(list));
    }
}
