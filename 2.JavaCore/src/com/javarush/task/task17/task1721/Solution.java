package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {

    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));
            bufferedReader.close();
            Solution solution = new Solution();
            String d;
            while ((d = bufferedReader1.readLine()) != null) {
                allLines.add(d);
            }
            while ((d = bufferedReader2.readLine()) != null) {
                forRemoveLines.add(d);
            }
            bufferedReader1.close();
            bufferedReader2.close();
            solution.joinData();
            for (String allLine : allLines) {
                System.out.println(allLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

