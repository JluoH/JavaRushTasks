package com.javarush.task.task31.task3103;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
    }
}

class Person implements Serializable {
    private transient int age;
    private transient int weight;
    private transient boolean isMan;
    private transient String name;

    public Person(int age, int weight, boolean isMan, String name) {
        this.age = age;
        this.weight = weight;
        this.isMan = isMan;
        this.name = name;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("age=").append(age);
        sb.append(", weight=").append(weight);
        sb.append(", isMan=").append(isMan);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}