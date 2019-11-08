package com.javarush.task.task16.task1633;

class Solution extends Thread {
    private String name1 = "Оля";
    private String name2 = "Лена";


    public void run() {
        String s = name1;
        name1 = name2;
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name2 = s;
        System.out.println(name1 + " " + name2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.start();
        s.run();
    }
}