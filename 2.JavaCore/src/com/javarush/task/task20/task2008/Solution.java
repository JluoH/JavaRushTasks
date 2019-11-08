package com.javarush.task.task20.task2008;

import java.util.Arrays;

/*
Как сериализовать Singleton?
*/
public class Solution {

    public static void main(String[] args) {
        int[] chars = {'a', 'b', 'c', 'd', 'a', 'e', 'f', 'g', 'a', 'k'};
        System.out.println(Arrays.asList(chars).indexOf('a'));
    }
}
