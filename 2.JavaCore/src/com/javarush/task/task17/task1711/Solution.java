package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {

    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        int i = -2;
                        while (!args[i += 3].isEmpty()) {
                            if (args[i + 1].equals("м"))
                                allPeople.add(Person.createMale(args[i], sdf1.parse(args[i + 2])));
                            else if (args[i + 1].equals("ж"))
                                allPeople.add(Person.createFemale(args[i], sdf1.parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);
                        }
                        break;
                    }
                case "-u":
                    synchronized (allPeople) {
                        int u = -3;
                        while (args[u += 4] != null) {
                            if (args[u + 2].equals("м")) {
                                allPeople.set(Integer.parseInt(args[u]), Person.createMale(args[u + 1], sdf1.parse(args[u + 3])));
                            } else if
                            (args[u + 2].equals("ж")) {
                                allPeople.set(Integer.parseInt(args[u]), Person.createFemale(args[u + 1], sdf1.parse(args[u + 3])));
                            }
                        }
                        break;
                    }
                case "-d":
                    synchronized (allPeople) {
                        int y = 0;
                        while (args[++y] != null) {
                            Person person = allPeople.get(Integer.parseInt(args[y]));
                            person.setName(null);
                            person.setSex(null);
                            person.setBirthDate(null);
                            allPeople.set(Integer.parseInt(args[y]), person);
                        }
                        break;
                    }
                case "-i":
                    synchronized (allPeople) {
                        int r = 0;
                        while (args[++r] != null) {
                            String sex = null;
                            if (allPeople.get(Integer.parseInt(args[r])).getSex() == Sex.MALE) sex = "м";
                            else if (allPeople.get(Integer.parseInt(args[r])).getSex() == Sex.FEMALE) sex = "ж";
                            System.out.println(allPeople.get(Integer.parseInt(args[r])).getName() + " " + sex + " " + sdf.format(allPeople.get(Integer.parseInt(args[r])).getBirthDate()));
                        }
                        break;
                    }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }
}
