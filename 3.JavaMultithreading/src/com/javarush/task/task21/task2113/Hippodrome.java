package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> list = new ArrayList<>();
        list.add(new Horse("1-ая", 3, 0));
        list.add(new Horse("2-ая", 3, 0));
        list.add(new Horse("uD83DuDC0E", 3, 0));
        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse hors : horses) {
            hors.move();
        }
    }

    public void print() {
        for (Horse hors : horses) {
            hors.print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        ArrayList<Double> list = new ArrayList<>();
        for (Horse hors : horses) {
            list.add(hors.getDistance());
        }
        Horse hur = null;
        for (Horse hors : horses) {
            if (Collections.max(list) == hors.getDistance()) hur = hors;
        }
        return hur;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
