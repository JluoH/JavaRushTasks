package com.javarush.task.task26.task2606;

/*
Тот, кто любит труд, не нуждается в развлечениях
*/
public class Solution {
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        proverka();
        proverka();
        proverka();
        proverka();
        proverka();
    }

    public static void proverka() throws InterruptedException {
        Thread thread = new Thread(() -> vyzov());
        Thread thread1 = new Thread(() -> vyzov());
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(2000000 - i);
        i = 0;
    }

    static Object object = new Object();

    public static void vyzov() {

            for (int j = 0; j < 1_000_000; j++) {
                i++;
            }

    }
}
