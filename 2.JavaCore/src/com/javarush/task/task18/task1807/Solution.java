package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        bufferedReader.close();
        if (fileInputStream.available() > 0) {
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            int x = 0;
            for (byte aByte : bytes) {
                if (aByte == 44) {
                    x++;
                }
            }
            System.out.println(x);
        }
        fileInputStream.close();
    }
}
