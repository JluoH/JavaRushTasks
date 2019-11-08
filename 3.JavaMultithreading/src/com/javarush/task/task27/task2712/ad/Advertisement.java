package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content; //файл видео
    private String name;    //название видео
    private long initialAmount; //стоимость всех показов в сумме (в копейках)
    private int hits;  //количество оплаченных показов
    private int duration; //продолжительность одного показа (в секундах)
    private long amountPerOneDisplaying; //стоимость одного показа (в копейках)
    private long amountPerOneSecond; //стоимость одной секунды показа (в копейках)

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = hits == 0 ? 0 : initialAmount / hits;
        this.amountPerOneSecond = duration == 0 ? 0 : amountPerOneDisplaying *1000/ duration;
    }

    public void revalidate() {
        this.hits--;
        if (this.hits < 0) {
            throw new UnsupportedOperationException();
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public double getAmountPerOneSecond() {
        return amountPerOneSecond;
    }

    @Override
    public String toString() {
        return String.format("%s is displaying... %s, %s", name, amountPerOneDisplaying, amountPerOneSecond);
    }
}
