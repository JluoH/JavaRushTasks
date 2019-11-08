package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> i = new ArrayList<Integer>();
        ArrayList<Integer> i1 = new ArrayList<Integer>();
        ArrayList<Integer> i2 = new ArrayList<Integer>();
        ArrayList<Integer> i3 = new ArrayList<Integer>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 20; j++) {
            i.add(Integer.parseInt(buff.readLine()));
        }
        for (Integer heh :
                i) {
            if (heh % 3 == 0) i1.add(heh);
            if (heh % 2 == 0) i2.add(heh);
            if (heh % 3 != 0 && heh % 2 != 0) i3.add(heh);
        }
        printList(i1);
        printList(i2);
        printList(i3);
    }

    public static void printList(List<Integer> list) {
        for (Integer hemund :
                list) {
            System.out.println(hemund);
        }
    }
}
