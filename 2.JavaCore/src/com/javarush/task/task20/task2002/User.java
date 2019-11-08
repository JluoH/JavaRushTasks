package com.javarush.task.task20.task2002;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Date;

public class User {

    public User() {
    }

    public User(String firstName, String lastName, Date birthDate, boolean isMale, Country country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.country = country;
    }

    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");
        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return this.name;
        }
    }

    public void save(PrintWriter writer) throws Exception {
        String isFirstName = firstName != null ? "yes" : "no";
        writer.println(isFirstName);
        writer.flush();
        if (isFirstName != null) {
            writer.println(firstName);
            writer.flush();
        }
        ///
        String isLastName = lastName != null ? "yes" : "no";
        writer.println(isLastName);
        writer.flush();
        if (isLastName != null) {
            writer.println(lastName);
            writer.flush();
        }
        ///
        String isBirthDate = birthDate != null ? "yes" : "no";
        writer.println(isBirthDate);
        writer.flush();
        if (isBirthDate != null) {
            writer.println(birthDate.getTime());
            writer.flush();
        }
        ///
        writer.println(isMale);
        writer.flush();
        ///
        String isCountry = country != null ? "yes" : "no";
        writer.println(isCountry);
        writer.flush();
        if (isCountry != null) {
            writer.println(country.getDisplayName());
            writer.flush();
        }
    }

    public void load(BufferedReader reader) throws Exception {
        String isFirstName = reader.readLine();
        if (isFirstName.equals("yes")) {
            firstName = reader.readLine();
        }
        String isLastName = reader.readLine();
        if (isLastName.equals("yes")) {
            lastName = reader.readLine();
        }
        String isBirthDate = reader.readLine();
        if (isBirthDate.equals("yes")) {
            String s = reader.readLine();
            birthDate = new Date(Long.parseLong(s));
        }
        isMale = Boolean.parseBoolean(reader.readLine());
        String isCountry = reader.readLine();
        if (isCountry.equals("yes")) {
            String sss = reader.readLine();
            for (Country cr : Country.values()) {
                if (sss.equals(cr.getDisplayName())) country = cr;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (isMale != user.isMale) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(user.birthDate) : user.birthDate != null) return false;
        return country == user.country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (isMale ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}