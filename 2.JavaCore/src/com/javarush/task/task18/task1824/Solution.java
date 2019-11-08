package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        {
            String s = null;
            ArrayList<FileInputStream> list = new ArrayList<>();
            try {
                while (true) {
                    list.add(new FileInputStream(s = bufferedReader.readLine()));
                }
            } catch (FileNotFoundException e) {
                System.out.println(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bufferedReader.close();
            for (FileInputStream fileInputStream : list) {
               if (fileInputStream != null){
                   fileInputStream.close();
               }
            }
        }
    }
}
