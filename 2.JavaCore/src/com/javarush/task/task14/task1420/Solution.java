package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        if (a<=0 || b<=0)
        {Exception th = new Exception();
            throw th;}
            else{
        while (a != 0 && b != 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }}
        System.out.println(a + b);}
        catch (NumberFormatException e){
            throw e;
        }}
    }

