package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        ;
        for (Word word : detectAllWords(crossword, "home", "same", "jhv", "gsf", "rrj", "rek", "glp", "rr")) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
jhv - (5, 4) - (5, 2)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        if (words != null) {
            ArrayList<Word> wordArrayList = new ArrayList<Word>();
            for (String word : words) {
                char[] bukvy = word.toCharArray();
                ArrayList<Integer> list1x = new ArrayList<Integer>();
                ArrayList<Integer> list1y = new ArrayList<Integer>();
                ArrayList<Integer> list2x = new ArrayList<Integer>();
                ArrayList<Integer> list2y = new ArrayList<Integer>();
                for (int j = 0; j < crossword.length; j++) {
                    for (int k = 0; k < crossword[j].length; k++) {
                        if (crossword[j][k] == bukvy[0]) {
                            list1x.add(k);
                            list1y.add(j);
                        }
                        if (crossword[j][k] == bukvy[bukvy.length - 1]) {
                            list2x.add(k);
                            list2y.add(j);
                        }
                    }
                }
                for (int p = 0; p < list1x.size(); p++) {
                    int x1 = list1x.get(p);
                    int y1 = list1y.get(p);
                    for (int j = 0; j < list2x.size(); j++) {
                        {
                            int x2 = list2x.get(j);
                            int y2 = list2y.get(j);
                            if ((x1 == x2) && (y1 == y2 + (bukvy.length - 1))) {
                                String ss = "";
                                for (int i = 0; i < bukvy.length; i++) {
                                    ss += (char) crossword[y1 - i][x1];
                                }
                                if (ss.equals(word)) {
                                    Word heh = new Word(word);
                                    heh.setStartPoint(x1, y1);
                                    heh.setEndPoint(x2, y2);
                                    wordArrayList.add(heh);
                                }
                            }

                            if ((x1 == x2) && (y1 == y2 - (bukvy.length - 1))) {
                                String ss = "";
                                for (int i = 0; i < bukvy.length; i++) {
                                    ss += (char) crossword[y1 + i][x1];
                                }
                                if (ss.equals(word)) {
                                    Word heh = new Word(word);
                                    heh.setStartPoint(x1, y1);
                                    heh.setEndPoint(x2, y2);
                                    wordArrayList.add(heh);
                                }
                            }
                            if ((y1 == y2) && (x1 == x2 + (bukvy.length - 1))) {
                                String ss = "";
                                for (int i = 0; i < bukvy.length; i++) {
                                    ss += (char) crossword[y1][x1 - i];
                                }
                                if (ss.equals(word)) {
                                    Word heh = new Word(word);
                                    heh.setStartPoint(x1, y1);
                                    heh.setEndPoint(x2, y2);
                                    wordArrayList.add(heh);
                                }
                            }
                            if ((y1 == y2) && (x1 == x2 - (bukvy.length - 1))) {
                                String ss = "";
                                for (int i = 0; i < bukvy.length; i++) {
                                    ss += (char) crossword[y1][x1 + i];
                                }
                                if (ss.equals(word)) {
                                    Word heh = new Word(word);
                                    heh.setStartPoint(x1, y1);
                                    heh.setEndPoint(x2, y2);
                                    wordArrayList.add(heh);
                                }
                            }
                            if ((x1 == x2 + (bukvy.length - 1)) && (y1 == y2 + (bukvy.length - 1))) {
                                String ss = "";
                                for (int i = 0; i < bukvy.length; i++) {
                                    ss += (char) crossword[y1 - i][x1 - i];
                                }
                                if (ss.equals(word)) {
                                    Word heh = new Word(word);
                                    heh.setStartPoint(x1, y1);
                                    heh.setEndPoint(x2, y2);
                                    wordArrayList.add(heh);
                                }
                            }
                            if ((x1 == x2 + (bukvy.length - 1)) && (y1 == y2 - (bukvy.length - 1))) {
                                String ss = "";
                                for (int i = 0; i < bukvy.length; i++) {
                                    ss += (char) crossword[y1 + i][x1 - i];
                                }
                                if (ss.equals(word)) {
                                    Word heh = new Word(word);
                                    heh.setStartPoint(x1, y1);
                                    heh.setEndPoint(x2, y2);
                                    wordArrayList.add(heh);
                                }
                            }
                            if ((x1 == x2 - (bukvy.length - 1)) && (y1 == y2 + (bukvy.length - 1))) {
                                String ss = "";
                                for (int i = 0; i < bukvy.length; i++) {
                                    ss += (char) crossword[y1 - i][x1 + i];
                                }
                                if (ss.equals(word)) {
                                    Word heh = new Word(word);
                                    heh.setStartPoint(x1, y1);
                                    heh.setEndPoint(x2, y2);
                                    wordArrayList.add(heh);
                                }
                            }
                            if ((x1 == x2 - (bukvy.length - 1)) && (y1 == y2 - (bukvy.length - 1))) {
                                String ss = "";
                                for (int i = 0; i < bukvy.length; i++) {
                                    ss += (char) crossword[y1 + i][x1 + i];
                                }
                                if (ss.equals(word)) {
                                    Word heh = new Word(word);
                                    heh.setStartPoint(x1, y1);
                                    heh.setEndPoint(x2, y2);
                                    wordArrayList.add(heh);
                                }
                            }
                        }
                    }
                }
            }
            return wordArrayList;
        }
        return null;
    }

    public static class Word {

        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
