package com.javarush.task.task18.task1805;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        Set<Integer> hashSet = new HashSet<>(list);
        list.clear();
        list.addAll(hashSet);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer+ " ");
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}
