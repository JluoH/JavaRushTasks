package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {

    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        //
        //
        //
        //
        if (args[0].equals("-c")) {
            if (args[2].equals("м"))
                allPeople.add(Person.createMale(args[1], sdf1.parse(args[3])));
            else if (args[2].equals("ж")) allPeople.add(Person.createFemale(args[1], sdf1.parse(args[3])));
            System.out.println(allPeople.size() - 1);
        }
        //
        //
        //
        //
        else if (args[0].equals("-u")) {
            if (args[3].equals("м")) {
                allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], sdf1.parse(args[4])));
            } else if
            (args[3].equals("ж")) {
                allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], sdf1.parse(args[4])));
            }
        }
        //
        //
        //
        //
        else if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            allPeople.set(Integer.parseInt(args[1]), person);
        }
        //
        //
        //
        //
        else if (args[0].equals("-i")) {
            String sex = null;
            if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE) sex = "м";
            else if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.FEMALE) sex = "ж";
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " + sex + " " + sdf.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
        }
    }
}
