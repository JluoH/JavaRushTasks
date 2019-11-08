package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n <= 150) {
            if (n == 0 || n == 1) return String.valueOf(1);
            else if (n < 0) return String.valueOf(0);
            else {
                int x = n - 1;
                BigInteger y = BigInteger.valueOf(x * n);
                while (x > 1) {
                    x = x - 1;
                    y = y.multiply(BigInteger.valueOf(x));
                }
                return String.valueOf(y);
            }
        }
        return "";
    }
}
