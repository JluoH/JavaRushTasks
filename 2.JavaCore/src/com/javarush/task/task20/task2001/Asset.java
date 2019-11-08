package com.javarush.task.task20.task2001;

import java.io.*;

public class Asset {

    public Asset(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Asset() {
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        if (Double.compare(asset.price, price) != 0) return false;
        return name != null ? name.equals(asset.name) : asset.name == null;
    }

    @Override
    public int hashCode() {
        return 3;
    }

    public void save(PrintWriter writer) throws Exception {
        String isNamePresent = name != null ? "yes" : "no";
        writer.println(isNamePresent);
        writer.flush();
        if (name != null) {
            writer.println(name);
            writer.flush();
        }
        writer.println(price);
        writer.flush();
    }

    public void load(BufferedReader reader) throws Exception {
        String isNamePresent = reader.readLine();
        if (isNamePresent.equals("yes")) {
            name = reader.readLine();
        }
        price = Double.parseDouble(reader.readLine());
    }
}
