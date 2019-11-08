package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 5; j++) {
            list.add(buff.readLine());
        }
        list.remove(2);
        for (int i = 3; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}


