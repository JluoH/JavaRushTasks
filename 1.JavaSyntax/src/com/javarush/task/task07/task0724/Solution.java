package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human h1 = new Human("hey", true, 90);
        Human h2 = new Human("hey", false, 90);
        Human h3 = new Human("hey", true, 90);
        Human h4 = new Human("hey", false, 90);
        Human h5 = new Human("hey", false, 50, h1, h2);
        Human h6 = new Human("hey", false, 50, h3, h4);
        Human h7 = new Human("hey", false, 20, h5, h6);
        Human h8 = new Human("hey", false, 20, h5, h6);
        Human h9 = new Human("hey", false, 20, h7, h8);
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println(h4.toString());
        System.out.println(h5.toString());
        System.out.println(h6.toString());
        System.out.println(h7.toString());
        System.out.println(h8.toString());
        System.out.println(h9.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.father != null)
                text += ", отец: " + this.father.name;
            if (this.mother != null)
                text += ", мать: " + this.mother.name;
            return text;
        }
    }
}