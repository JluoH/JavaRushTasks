package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list = fix(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> list1 = new ArrayList<String>();
        for (String str : list) {
            if (str.indexOf("р") != -1 && str.indexOf("л") != -1) {
                list1.add(str);
            } else if (str.indexOf("р") != -1) {
            } else if (str.indexOf("л") != -1) {
                list1.add(str);
                list1.add(str);
            } else list1.add(str);
        }
        return list1;
    }
}