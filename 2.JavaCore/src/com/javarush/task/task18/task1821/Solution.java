package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] bytes = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0) {
            fileInputStream.read(bytes);
            Arrays.sort(bytes);
        }
        ArrayList<Byte> list = new ArrayList<>();
        TreeSet<Byte> treeSet = new TreeSet<>();
        for (byte aByte : bytes) {
            treeSet.add(aByte);
            list.add(aByte);
        }
        byte b;
        for (Byte aByte : treeSet) {
            b = aByte;
            System.out.println((char) b + " " + Collections.frequency(list, b));
        }
        fileInputStream.close();
    }
}
