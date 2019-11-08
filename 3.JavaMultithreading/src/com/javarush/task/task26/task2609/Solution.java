package com.javarush.task.task26.task2609;

import java.util.concurrent.atomic.AtomicInteger;

/*
Распределение элементов по корзинам с собственным локом
*/
public class Solution {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.decrementAndGet());
        System.out.println(atomicInteger.toString());
    }
}
