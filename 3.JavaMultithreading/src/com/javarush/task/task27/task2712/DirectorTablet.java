package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        StatisticManager manager = StatisticManager.getInstance();
        Map<Date, Long> map = manager.totalProfit();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        map.forEach((date, aLong) -> ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"%s - %.2f", sdf.format(date), aLong / 100.0)));
        long sum = map.values().stream().mapToLong(value -> value).sum();
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"Total - %.2f", + sum / 100.0));
    }

    public void printCookWorkloading() {
        StatisticManager manager = StatisticManager.getInstance();
        Map<Date, Map<String, Integer>> map = manager.totalWorkDuration();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<Date, Map<String, Integer>> entry : map.entrySet()) {
            ConsoleHelper.writeMessage(sdf.format(entry.getKey()));
            for (Map<String, Integer> value : map.values()) {
                for (Map.Entry<String, Integer> integerEntry : value.entrySet()) {
                    ConsoleHelper.writeMessage(String.format("%s - %s min", integerEntry.getKey(), (int) (Math.ceil(integerEntry.getValue() / 60.0))));
                }
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        StatisticAdvertisementManager manager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> activeVideoSet = manager.getActiveVideoSet();
        activeVideoSet.sort(Comparator.comparing(x -> x.getName().toLowerCase()));
        activeVideoSet.forEach(x -> ConsoleHelper.writeMessage(x.getName() + " - " + x.getHits()));
    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager manager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> archivedVideoSet = manager.getArchivedVideoSet();
        archivedVideoSet.sort(Comparator.comparing(x -> x.getName().toLowerCase()));
        archivedVideoSet.forEach(x -> ConsoleHelper.writeMessage(x.getName()));

    }
}
