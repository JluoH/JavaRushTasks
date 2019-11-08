package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private int age1;
        private int age2;
        private int age3;
        private String age4;
        private int age5;

        public Human(String age4, int age5) {
            this.age4 = age4;
            this.age5 = age5;
        }

        public Human(int age, int age1, int age2, int age3, String age4) {
            this.age = age;
            this.age1 = age1;
            this.age2 = age2;
            this.age3 = age3;
            this.age4 = age4;
        }


        public Human(int age, int age1) {
            this.age = age;
            this.age1 = age1;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(int age1, int age2, int age3) {
            this.age1 = age1;
            this.age2 = age2;
            this.age3 = age3;
        }

        public Human(int age, int age1, int age2, int age3) {
            this.age = age;
            this.age1 = age1;
            this.age2 = age2;
            this.age3 = age3;
        }

        public Human(int age1, int age2, int age3, String age4, int age5) {
            this.age1 = age1;
            this.age2 = age2;
            this.age3 = age3;
            this.age4 = age4;
            this.age5 = age5;
        }

        public Human(int age1, int age2, int age3, String age4) {
            this.age1 = age1;
            this.age2 = age2;
            this.age3 = age3;
            this.age4 = age4;
        }

        public Human(int age, int age2, String age4, int age5) {
            this.age = age;
            this.age2 = age2;
            this.age4 = age4;
            this.age5 = age5;
        }

        public Human(String age4) {
            this.age4 = age4;
        }
    }
}
