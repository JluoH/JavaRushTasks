package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

import static com.javarush.task.task27.task2712.statistic.event.EventType.NO_AVAILABLE_VIDEO;

public class NoAvailableVideoEventDataRow implements EventDataRow {
    private int totalDuration;
    private Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public Date getDate() {
        return currentDate;
    }

    public int getTime() {
        return totalDuration;
    }

    @Override
    public EventType getType() {
        return NO_AVAILABLE_VIDEO;
    }
}
