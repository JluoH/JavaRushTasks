package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public static void main(String[] args) {
        new Solution("Kepe") {
            void hey() {
                System.out.println(getName());
            }
        }.hey();
    }
}
