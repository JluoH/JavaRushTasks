package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {

    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream1);
        testString.printSomething();
        System.setOut(printStream);
        String s = byteArrayOutputStream.toString();
        int x = Integer.parseInt(s.split(" ")[0]);
        int y = Integer.parseInt(s.split(" ")[2]);
        int u = 0;
        if (s.split(" ")[1].equals("+")) {
            u = x + y;
            System.out.print(x + " + " + y + " = " + u);
        }
        else if (s.split(" ")[1].equals("-")) {
            u = x - y;
            System.out.print(x + " - " + y + " = " + u);
        }
        else if (s.split(" ")[1].equals("*")) {
            u = x * y;
            System.out.print(x + " * " + y + " = " + u);
        }

    }

    public static class TestString {

        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

