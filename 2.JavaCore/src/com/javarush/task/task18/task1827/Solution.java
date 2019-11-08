package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            if (args[0].equals("-c")) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferedReader.readLine();
                bufferedReader.close();
                BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
                String h;
                ArrayList<String> list = new ArrayList<>();
                while ((h = bufferedReader1.readLine()) != null) {
                    list.add(h);
                }
                ArrayList<Integer> lsd = new ArrayList<>();
                for (String s1 : list) {
                    String hfd = s1.substring(0, 8);
                    String knh = hfd.trim();
                    int hhh = Integer.parseInt(knh);
                    lsd.add(hhh);
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(s, true)));
                int x = Collections.max(lsd) + 1;
                String sx = String.valueOf(x);
                while (sx.length() < 8) {
                    sx += " ";
                }
                String hj = "";
                if (args.length - 3 > 1) {
                    int i = 1;
                    while (args.length - 3 >= i) {
                        hj += args[i] + " ";
                        i++;
                    }
                } else {
                    hj = args[1];
                }
                while (hj.length() < 30) {
                    hj += " ";
                }
                String bb = args[args.length - 2];
                while (bb.length() < 8) {
                    bb += " ";
                }
                String gg = args[args.length - 1];
                while (gg.length() < 4) {
                    gg += " ";
                }
                if (sx.length() > 8) {
                    sx = sx.substring(0, 8);
                }
                if (hj.length() > 30) {
                    hj = hj.substring(0, 30);
                }
                if (bb.length() > 8) {
                    bb = bb.substring(0, 8);
                }
                if (gg.length() > 4) {
                    gg = gg.substring(0, 4);
                }
                bufferedWriter.write("\r\n" + sx + hj + bb + gg);
                bufferedWriter.close();
                bufferedReader1.close();
            }
        }
    }
}
