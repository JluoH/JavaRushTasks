package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);
        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);
        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        try {
            Properties properties = new Properties();
            if (fileName.toLowerCase().endsWith(".xml")) {
                properties.loadFromXML(new FileInputStream(fileName));
            } else {
                properties.load(new FileReader(fileName));
            }
            return properties;
        } catch (Exception e) {
            return new Properties();
        }
    }
}

