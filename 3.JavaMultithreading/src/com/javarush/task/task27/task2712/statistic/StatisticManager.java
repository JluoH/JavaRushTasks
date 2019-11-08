package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager statisticManager;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (statisticManager == null) {
            statisticManager = new StatisticManager();
        }
        return statisticManager;
    }

    public Map<Date, Map<String, Integer>> totalWorkDuration() {
        Map<Date, Map<String, Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        Map<String, Integer> vnMap = new TreeMap<>();
        List<EventDataRow> rows = statisticStorage.storage.get(EventType.COOKED_ORDER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String dateStr = null;
        Date date = null;
        for (EventDataRow row : rows) {
            CookedOrderEventDataRow coedr = (CookedOrderEventDataRow) row;
            String curDate = simpleDateFormat.format(coedr.getDate());
            if (dateStr == null) {
                dateStr = curDate;
                date = coedr.getDate();
            }
            if (dateStr.equals(curDate)) {
                String name = coedr.getCookName();
                int time = coedr.getTime();
                if (vnMap.containsKey(name)) {
                    Integer integer = vnMap.get(name);
                    vnMap.put(name, integer + time);
                } else {
                    vnMap.put(name, time);
                }
            } else {
                map.put(date, vnMap);
                vnMap.clear();
                dateStr = curDate;
                date = coedr.getDate();
            }
        }
        map.put(date, vnMap);
        return map;
    }

    public Map<Date, Long> totalProfit() {
        List<EventDataRow> rows = statisticStorage.storage.get(EventType.SELECTED_VIDEOS);
        Map<Date, Long> map = new TreeMap<>(Comparator.reverseOrder());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String dateStr = null;
        Date date = null;
        long totalMoney = 0;
        for (EventDataRow row : rows) {
            VideoSelectedEventDataRow vsed = (VideoSelectedEventDataRow) row;
            String curDate = simpleDateFormat.format(vsed.getDate());
            if (dateStr == null) {
                dateStr = curDate;
                date = vsed.getDate();
            }
            if (dateStr.equals(curDate)) {
                totalMoney += vsed.getAmount();
            } else {
                map.put(date, totalMoney);
                totalMoney = vsed.getAmount();
                dateStr = curDate;
                date = vsed.getDate();
            }
        }
        map.put(date, totalMoney);
        return map;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            storage.put(EventType.COOKED_ORDER, new ArrayList<EventDataRow>());
            storage.put(EventType.SELECTED_VIDEOS, new ArrayList<EventDataRow>());
            storage.put(EventType.NO_AVAILABLE_VIDEO, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data) {
            List<EventDataRow> list = storage.get(data.getType());
            list.add(data);
        }
    }
}
