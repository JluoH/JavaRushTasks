package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(buff.readLine()));
        }
        int q1 = 1;
        int q2 = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                q1++;
            } else {
                if (q1 > q2) {
                    q2 = q1;
                }
                q1 = 1;
            }
        }
        if (q1 > q2) {
            q2 = q1;
        }
        System.out.println(q2);
    }
}