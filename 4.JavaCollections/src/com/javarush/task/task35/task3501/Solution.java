package com.javarush.task.task35.task3501;

import java.util.ArrayList;
import java.util.List;

/*
Вызов статического метода
*/
public class Solution {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(300);
        list.add(300.0);
        list.add(new Object());
        list.forEach(System.out::println);
    }
}
