package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileReader;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] h = new int[5];
            int y = h[5];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            ArrayList<Integer> hh = new ArrayList<>();
            int yy = hh.get(1);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            File f = new File("dfdf");
            FileReader fr = new FileReader(f);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Integer i = null;
            System.out.println(i/8);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Integer.parseInt("qq");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int jh [] = new int[-1];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Exception ef = new Exception();
            throw ef;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Exception ejf = new IllegalThreadStateException();
            throw ejf;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Exception eggf = new SyncFailedException("sds");
            throw eggf;
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
