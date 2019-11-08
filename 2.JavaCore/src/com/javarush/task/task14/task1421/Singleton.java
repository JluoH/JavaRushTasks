package com.javarush.task.task14.task1421;

public class Singleton {
    static private Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance(){
        return instance;
    }
}
