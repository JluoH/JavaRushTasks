package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime() {
        return dishes.stream().mapToInt(Dish::getDuration).sum();
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("Your order: [");
        for (Dish dish : dishes) {
            sb.append(dish.name()).append(", ");
        }
        String s = sb.substring(0, sb.length() - 2);
        sb = new StringBuilder(s);
        sb.append("] of ").append(tablet.toString());
        return sb.toString();
    }
}
