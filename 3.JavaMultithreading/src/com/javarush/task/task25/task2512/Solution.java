package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        Throwable cause = e;
        list.add(e);
        while ((cause = cause.getCause()) != null) {
            list.add(cause);
        }
        Collections.reverse(list);
        list.forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(new Solution());
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));   }
}
