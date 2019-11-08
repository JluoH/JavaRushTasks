package com.javarush.task.task27.task2710;

/* 
Расставьте wait-notify
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) ;
        });
        thread.start();
        Thread.sleep(2000);
        thread.stop();
    }
}
