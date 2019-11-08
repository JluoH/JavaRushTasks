package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/*
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        ArrayList<String> list = new ArrayList();
        while (true) {
            s = bufferedReader.readLine();
            if (s.equals("exit")) break;
            else {
                list.add(s);
            }
        }
        for (String o : list) {
            try {
                if (Short.parseShort(o) > 0 && Short.parseShort(o) < 128) print(Short.parseShort(o));
                else {
                    Exception yy = new Exception();
                    throw yy;
                }
            } catch (Exception e) {
                try {
                    print(Integer.parseInt(o));
                } catch (Exception ez) {
                    try {
                        print(Double.parseDouble(o));
                    } catch (Exception ee) {
                        print(o);
                    }
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
