package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(buff.readLine())));
        ArrayList<Integer> list1 = new ArrayList<>();
        String s;
        while ((s = br.readLine()) != null) {
            list1.add(Integer.parseInt(s));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : list1) {
            if (integer % 2 == 0){
                list.add(integer);
            }
        }
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
        br.close();
        buff.close();
    }
}
