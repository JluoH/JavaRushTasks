package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {

    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = bufferedReader.readLine()).equals("exit")) {
            new ReadThread(s).start();
        }
    }

    public static class ReadThread extends Thread {

        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                byte[] bytes = new byte[fileInputStream.available()];
                if (fileInputStream.available() > 0) {
                    fileInputStream.read(bytes);
                    ArrayList<Byte> list = new ArrayList<>();
                    for (byte aByte : bytes) {
                        list.add(aByte);
                    }
                    int y = 0;
                    byte x = list.get(0);
                    for (Byte aByte : list) {
                        if (Collections.frequency(list, aByte) > y) {
                            x = aByte;
                            y = Collections.frequency(list, aByte);
                        }
                    }
                    resultMap.put(fileName, (int) x);
                }
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
