package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList <Human> deti0 = new ArrayList<Human>();
        Human h1 = new Human("Антон", true, 20, deti0);
        Human h2 = new Human("Антон", true, 20, deti0);
        Human h3 = new Human("Антон", true, 20, deti0);
        ArrayList <Human> deti = new ArrayList<Human>();
        deti.add(h1);
        deti.add(h2);
        deti.add(h3);
        Human h4 = new Human("Надежда", false, 50, deti);
        Human h5 = new Human("Олег", true, 50, deti);
        ArrayList <Human> deti1 = new ArrayList<Human>();
        deti1.add(h4);
        ArrayList <Human> deti2 = new ArrayList<Human>();
        deti2.add(h5);
        Human h6 = new Human("Татьяна", false, 80, deti1);
        Human h7 = new Human("Надежда", false, 80, deti2);
        Human h8 = new Human("Кирилл", true, 80, deti1);
        Human h9 = new Human("Владимир", true, 80, deti2);
        System.out.println(h9);
        System.out.println(h8);
        System.out.println(h7);
        System.out.println(h6);
        System.out.println(h5);
        System.out.println(h4);
        System.out.println(h3);
        System.out.println(h2);
        System.out.println(h1);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;
                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
