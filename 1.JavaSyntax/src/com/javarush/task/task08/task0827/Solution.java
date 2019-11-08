package com.javarush.task.task08.task0827;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date data = new Date(date);
        Calendar cal = new GregorianCalendar();
        cal.setTime(data);
        if (cal.get(Calendar.DAY_OF_YEAR) % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
