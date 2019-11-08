package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(buff.readLine());
        }
        int z0 = list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > z0) {
                z0 = list.get(i).length();
            } else {
                System.out.println(i);
                break;
            }
        }
    }
}

