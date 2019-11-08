package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        load(fis);
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties properties1 = new Properties();
        properties1.putAll(properties);
        properties1.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties properties1 = new Properties();
        properties1.load(inputStream);
        for (Map.Entry<Object, Object> entry : properties1.entrySet()) {
            properties.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static void main(String[] args) {
    }
}
