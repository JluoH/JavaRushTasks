package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            arrayList.add(fileInputStream.read());
        }
        bufferedReader.close();
        fileInputStream.close();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (Integer integer : arrayList) {
            hashMap.put(integer, Collections.frequency(arrayList, integer));
        }

        ArrayList<Integer> arrayList1 = new ArrayList<>(hashMap.values());
        int x = Collections.min(arrayList1);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == x) System.out.print(entry.getKey() + " ");
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}
