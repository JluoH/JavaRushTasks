package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        Map<String, ByteArrayOutputStream> map = new TreeMap<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1000];
                int count = 0;
                while ((count = zipInputStream.read(buffer)) != -1)
                    byteArrayOutputStream.write(buffer, 0, count);
                byte[] b = new byte[(int) zipEntry.getSize()];
                zipInputStream.read(b);
                map.put(zipEntry.getName(), byteArrayOutputStream);
            }
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]))) {
            String[] mass = args[0].split("/");
            String file = mass[mass.length - 1];
            zipOutputStream.putNextEntry(new ZipEntry("new/" + file));
            Files.copy(Paths.get(args[0]), zipOutputStream);

            for (Map.Entry<String, ByteArrayOutputStream> entry : map.entrySet()) {
                if (!entry.getKey().equals(file)) {
                    zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));
                    zipOutputStream.write(entry.getValue().toByteArray());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
