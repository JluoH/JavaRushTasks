package com.javarush.task.task27.task2707;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj2) {
            synchronized (obj1) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        synchronized (o1) {
            Thread thread1 = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));
            thread1.setDaemon(true);
            thread1.start();
            Thread thread2 = new Thread(() -> {
                synchronized (o2) {
                }
            });
            thread2.setDaemon(true);
            thread2.start();
            while (thread2.getState() == Thread.State.RUNNABLE) ;
            return thread2.getState() == Thread.State.TERMINATED;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();
        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
