package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();
        String s = "";
        if (bufferedReader1.ready()) {
            s += bufferedReader1.readLine();
        }
        bufferedReader1.close();
        String[] mass = s.split(" ");
        for (String mass1 : mass) {
            try {
                Double.parseDouble(mass1);
                bufferedWriter.write(mass1 + " ");
            } catch (NumberFormatException e) {

            } catch (IOException e) {

            }
        }
        bufferedWriter.close();
    }
}
