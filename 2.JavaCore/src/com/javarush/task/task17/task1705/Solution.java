package com.javarush.task.task17.task1705;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, InterruptedException {
        //создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileInputStream inputStream = new FileInputStream("C:\\\\GH1.TXT");
        long sum = 0;
        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            System.out.print((char) inputStream.read()); //прочитать очередной байт
        }
        inputStream.close(); // закрываем поток
    }
}