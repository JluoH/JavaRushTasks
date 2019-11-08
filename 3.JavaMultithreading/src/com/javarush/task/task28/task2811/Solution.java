package com.javarush.task.task28.task2811;

/* 
ReentrantReadWriteLock
*/

public class Solution {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(0);
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
}
