package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        String s = "";
        while (bufferedReader.ready()){
            s+=bufferedReader.readLine()+ " ";
        }
        String [] se = s.split(" ");
        s ="";
        for (String s1 : se) {
            if(s1.length()>6){
                s+=s1+",";
            }
        }
        bufferedWriter.write(s, 0, s.length()-1);
        bufferedReader.close();
        bufferedWriter.close();
    }
}
