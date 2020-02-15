package com.javarush.task.task31.task3103;

import java.util.Objects;

public class Animal implements Comparable<Animal> {
    protected int age;
    private String name;

    public Animal() {
        this.age = 1;
        this.name = "Default";
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    static void Method() {
        System.out.println("Это статический метод");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Мне песда...");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Animal o) {
        return Integer.compare(this.age, o.age);
    }
}