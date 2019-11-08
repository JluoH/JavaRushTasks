package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {

    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        String st = "";
        while (reader1.ready()) {
            st += reader1.readLine() + " ";
        }
        String[] mass = st.split(" ");
        for (int i = 0; i < mass.length; i++) {
            String s = mass[i];
            String srev = new StringBuilder(s).reverse().toString();
            for (int j = 0; j < mass.length; j++) {
                String s1 = mass[j];
                if (srev.equals(s1) && i != j) {
                    Pair pair = new Pair(s, s1);
                    boolean b = false;
                    for (Pair pair1 : result) {
                        if (pair.first.equals(pair1.first) || pair.first.equals(pair1.second)) {
                            b = true;
                        }
                    }
                    if (!b) {
                        result.add(pair);
                    }
                }
            }
        }
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}
