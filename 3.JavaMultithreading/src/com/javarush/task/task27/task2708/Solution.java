package com.javarush.task.task27.task2708;

/*
Убираем deadLock используя открытые вызовы
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                pe4at();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(100);
        synchronized (Solution.class) {
            System.out.println(thread.getState());
            Solution.class.notify();
            System.out.println(thread.getState());
        }
    }

    public static synchronized void pe4at() throws InterruptedException {
        System.out.println("1-oe");
        Solution.class.wait(10000000);
        System.out.println("2-oe");
    }
}