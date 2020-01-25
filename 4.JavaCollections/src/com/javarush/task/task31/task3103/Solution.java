package com.javarush.task.task31.task3103;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Mass mass = new Mass(26, "Oleg");
        System.out.println(Arrays.toString(mass.getClass().getDeclaredMethods()));
    }

    static class Mass {
        int age;
        String name;

        public Mass(int age, String name) {
            this.age = age;
            this.name = name;
        }

        String coll() {
            return name + " " + age + " лет";
        }
    }
}

