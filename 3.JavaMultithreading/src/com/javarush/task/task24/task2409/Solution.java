package com.javarush.task.task24.task2409;

import java.util.ArrayList;

class Car {
    public ArrayList<Car> createPoliceCars(int count) {
        ArrayList<Car> result = new ArrayList<Car>();
        for (int i = 0; i < count; i++) {
            final int number = i;
            result.add(new Car() {
                int policeNumber;

                {
                    policeNumber = number;
                }
            });
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Car().createPoliceCars(5));
    }
}
