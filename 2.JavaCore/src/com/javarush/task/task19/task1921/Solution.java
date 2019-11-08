package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {

    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader ce = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> list = new ArrayList<>();
        while (ce.ready()) {
            list.add(ce.readLine());
        }
        SimpleDateFormat sim = new SimpleDateFormat("dd M yyyy");
        for (String s : list) {
            String[] ma = s.split(" ");
            Date date = sim.parse(ma[ma.length - 3] + " " + ma[ma.length - 2] + " " + ma[ma.length - 1]);
            String im9 = "";
            for (int i = 0; i < ma.length - 3; i++) {
                im9 += ma[i] + " ";
            }
            PEOPLE.add(new Person(im9.trim(), date));
        }
        ce.close();
    }
}