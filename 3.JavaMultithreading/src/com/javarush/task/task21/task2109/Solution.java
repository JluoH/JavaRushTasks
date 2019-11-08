package com.javarush.task.task21.task2109;

import java.util.ArrayList;

/*
Запретить клонирование
*/
public class Solution {

    public static void main(String[] args) {
        ArrayList<String> mass = new ArrayList<String>();
        mass.add("1");
        mass.add("2");
        mass.add("3");
        ArrayList<String> clon = (ArrayList<String>) mass.clone();
        for (String i : mass) {
            System.out.print(i + " ");
        }
        System.out.println();
        clon.set(2, "kekmund");
        for (String i : clon) {
            System.out.print(i + " ");
        }
    }
}
