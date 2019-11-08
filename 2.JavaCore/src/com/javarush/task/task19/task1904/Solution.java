package com.javarush.task.task19.task1904;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws ParseException {
            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
            Date birthDate = simpleDateFormat.parse(fileScanner.next() + fileScanner.next() + fileScanner.next());
            Person person = new Person(firstName, middleName, lastName, birthDate);
            return person;
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}
