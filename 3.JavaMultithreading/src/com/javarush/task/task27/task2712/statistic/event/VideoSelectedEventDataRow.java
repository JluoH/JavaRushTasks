package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

import static com.javarush.task.task27.task2712.statistic.event.EventType.SELECTED_VIDEOS;

public class VideoSelectedEventDataRow implements EventDataRow {
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public Date getDate() {
        return currentDate;
    }

    public long getAmount() {
        return amount;
    }

    public int getTime() {
        return totalDuration;
    }

    @Override
    public EventType getType() {
        return SELECTED_VIDEOS;
    }
}
