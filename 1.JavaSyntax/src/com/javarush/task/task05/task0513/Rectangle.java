package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    private int top;
    private int left;
    private int width;
    private int height;

    public void initialize(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top, int left) {
        this.top = top;
        this.left = left;
        this.width = left;
        this.height = top;
    }

    public void initialize(int width, int left, int height) {
        this.top = height;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top) {
        this.top = top;
        this.left = top;
        this.width = top;
        this.height = top;
    }

    public static void main(String[] args) {
    }
}
