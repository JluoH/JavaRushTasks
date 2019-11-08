package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        writeMessage("Введите одно из блюд отображённых сверху или \'exit\' если хотите выйти");
        ArrayList<Dish> list = new ArrayList<>();
        while (true) {
            String s = readString();
            if (s.equals("exit")) {
                break;
            }
            try {
                list.add(Dish.valueOf(s));
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Такого блюда нет в меню");
            }
        }
        return list;
    }
}
