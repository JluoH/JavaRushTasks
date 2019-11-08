package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String s = "";
        while (fr.ready()) {
            s += fr.readLine();
        }
        fr.close();

        Document s7 = Jsoup.parse(s, " ", Parser.xmlParser());
        Elements elements = s7.select(args[0]);
        for (Element element : elements) {
            System.out.println(element);
        }
    }
}
