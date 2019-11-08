package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution implements Serializable {

    public static class A implements Serializable{

        protected String name;
    }

    public class B extends A implements Serializable {

        public B(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();// создаём выходной поток массива байтов
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);// создаём поток для записи объектов в arrayOutputStream
        Solution solution = new Solution();// создаём экземпляр класса Solution
        B b = solution.new B("Maslik");
        System.out.println("nameB: " + b.name);
        oos.writeObject(b);
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);
        B b1 = (B) ois.readObject();
        System.out.println("nameB: " + b1.name);
        ;
    }
}
