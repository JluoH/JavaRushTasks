package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buff1 = new BufferedWriter(new FileWriter(new File(buff.readLine())));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = buff.readLine();
            if (s.equals("exit")) {
                list.add(s);
                break;
            } else {
                list.add(s);
            }
        }
        for (String s : list) {
            buff1.write(s);
            buff1.write("\r\n");
        }
        buff.close();
        buff1.close();
    }
}
