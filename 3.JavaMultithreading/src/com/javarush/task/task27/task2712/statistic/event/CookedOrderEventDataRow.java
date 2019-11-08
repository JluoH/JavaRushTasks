package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

import static com.javarush.task.task27.task2712.statistic.event.EventType.COOKED_ORDER;

public class CookedOrderEventDataRow implements EventDataRow {
    private String tabletName;
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> cookingDishs;
    private Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        this.currentDate = new Date();
    }

    public String getCookName() {
        return cookName;
    }

    public Date getDate() {
        return currentDate;
    }

    public int getTime() {
        return cookingTimeSeconds;
    }

    @Override
    public EventType getType() {
        return COOKED_ORDER;
    }
}
