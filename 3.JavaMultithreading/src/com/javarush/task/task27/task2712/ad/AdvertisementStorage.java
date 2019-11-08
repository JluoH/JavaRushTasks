package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage advertisementStorage;
    final private List<Advertisement> videos = new ArrayList();

    private AdvertisementStorage() {
        videos.add(new Advertisement(new Object(), "Первый рекламный ролик", 5000, 100, 3 * 60));
        videos.add(new Advertisement(new Object(), "Второй рекламный ролик", 100, 10, 15 * 60));
        videos.add(new Advertisement(new Object(), "Третий рекламный ролик", 400, 1, 10 * 60));
        videos.add(new Advertisement(new Object(), "Четвёртый рекламный ролик", 1000, 23, 1 * 60));
        videos.add(new Advertisement(new Object(), "Пятый рекламный ролик", 300, 1, 10 * 60));
    }

    public static AdvertisementStorage getInstance() {
        if (advertisementStorage == null) {
            advertisementStorage = new AdvertisementStorage();
        }
        return advertisementStorage;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public List<Advertisement> list() {
        return videos;
    }
}
