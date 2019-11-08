package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
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
            hashMap.put(integer, 0);
        }
        HashMap<Integer, Integer> hashMap1 = new HashMap<Integer, Integer>();
        for (Integer integer : hashMap.keySet()) {
            int count = 0;
            for (Integer integer1 : arrayList) {
                if (integer1 == integer) {
                    count++;
                }
            }
            hashMap1.put(integer, count);
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>(hashMap1.values());
        int x = Collections.max(arrayList1);
        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
            if (entry.getValue()==x) System.out.print(entry.getKey()+ " ");
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}
