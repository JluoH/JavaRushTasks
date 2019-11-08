package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        double mediana;
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            mediana = (array[array.length / 2] + array[array.length / 2 - 1])/2;
        } else mediana = array[array.length / 2];
        Arrays.sort(array, Comparator.comparing((Integer x) -> Math.abs(mediana - x)).thenComparing(Comparator.naturalOrder()));
        return array;
    }
}
