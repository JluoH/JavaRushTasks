package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

public class KidBoy implements Human {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KidBoy{");
        sb.append('}');
        return sb.toString();
    }

    public static final int MAX_AGE = 12;
}
