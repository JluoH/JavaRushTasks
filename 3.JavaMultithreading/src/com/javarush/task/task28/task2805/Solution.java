package com.javarush.task.task28.task2805;

/*
Приоритеты в Threads
*/
public class Solution {

    public static void main(String[] args) {
        MyThread.tipaMetod();
        MyThread.tipaMetod();
        MyThread.tipaMetod();
        System.out.println();
        new MyThread();
        System.out.println();
        new MyThread();
        System.out.println();
        new MyThread();
    }

}
