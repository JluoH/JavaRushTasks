package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    final private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private List<Advertisement> bestList;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> list = storage.list();
        ArrayList<Advertisement> listbez0 = null;
        if (!list.isEmpty()) {
            ArrayList<Advertisement> buff = new ArrayList<>();
            list.stream().filter(x -> x.getHits() > 0 && x.getDuration() <= this.timeSeconds).forEach(x -> buff.add(x));
            listbez0 = buff;
        }
        if (list.isEmpty() || listbez0.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        recursion(listbez0);
        if (bestList != null && !bestList.isEmpty()) {
            Collections.sort(bestList, Comparator.comparing(Advertisement::getAmountPerOneDisplaying, Comparator.reverseOrder()).thenComparing(Advertisement::getAmountPerOneSecond));
            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(bestList, bestList.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum(),bestList.stream().mapToInt(Advertisement::getDuration).sum()));
            bestList.forEach(x -> {
                ConsoleHelper.writeMessage(x.toString());
                x.revalidate();
            });
        }
    }

    private void recursion(List<Advertisement> list) {
        if (!list.isEmpty()) {
            if (this.bestList == null) {
                if (list.stream().mapToInt(Advertisement::getDuration).sum() <= this.timeSeconds) {
                    this.bestList = list;
                }
            } else {
                long sumPrice = list.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum();
                int sumTime = list.stream().mapToInt(Advertisement::getDuration).sum();
                long bestPrice = this.bestList.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum();
                if (sumTime <= this.timeSeconds && sumPrice >= bestPrice) {
                    if (bestPrice == sumPrice) {
                        int sumBestTime = this.bestList.stream().mapToInt(Advertisement::getDuration).sum();
                        if (sumTime >= sumBestTime) {
                            if (sumTime == sumBestTime) {
                                if (list.size() < this.bestList.size()) {
                                    this.bestList = list;
                                }
                            } else {
                                this.bestList = list;
                            }
                        }
                    } else {
                        this.bestList = list;
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            List<Advertisement> newList = new ArrayList<>(list);
            newList.remove(i);
            recursion(newList);
        }
    }
}
