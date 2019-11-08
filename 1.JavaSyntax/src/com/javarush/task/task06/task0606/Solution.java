package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {
    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(buffer.readLine());
        if (h / 10000 % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        if (h / 1000 % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        if (h / 100 % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        if (h / 10 % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        if (h % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        System.out.print("Even:" + even + "Odd: " + odd);
    }
}
