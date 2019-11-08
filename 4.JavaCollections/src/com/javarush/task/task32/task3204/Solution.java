package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 48; i < 58; i++) {
            list.add((char) i);
        }
        for (int i = 65; i < 91; i++) {
            list.add((char) i);
        }
        for (int i = 65; i < 91; i++) {
            list.add((char) i);
        }
        for (int i = 97; i < 123; i++) {
            list.add((char) i);
        }
        Collections.shuffle(list);
        String s = "";
        while (true) {
            for (int i = 0; i < 8; i++) {
                s += list.get(i);
            }
            if (s.matches(".*\\d.*")&& s.matches(".*[az].*") && s.matches(".*[AZ].*")) {
                break;
            }
            else {
                s= "";
                Collections.shuffle(list);
            }
        }
        baos.write(s.getBytes());
        return baos;
    }
}