package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        String s = "";
        while (bufferedReader.ready()) {
            s += bufferedReader.readLine() + " ";
        }
        String[] mass = s.split(" ");
        for (String mass1 : mass) {
            char[] chars = mass1.toCharArray();
            for (char aChar : chars) {
                if (aChar >= '0' && aChar <= '9') {
                    bufferedWriter.write(mass1 + " ");
                    break;
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
