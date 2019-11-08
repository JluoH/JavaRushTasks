package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
          list.add(buff.readLine());
        }
        ArrayList<String> result = new ArrayList<String>();
        result = doubleValues(list);
        for (String s :
                result) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        int i = 0;
        for (String y:
             list) {
          list.add(i+1, y);
        i++;
        }
        return list;
    }
}
