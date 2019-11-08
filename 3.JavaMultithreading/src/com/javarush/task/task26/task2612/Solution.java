package com.javarush.task.task26.task2612;

/*
Весь мир играет комедию
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    throw new RuntimeException();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

