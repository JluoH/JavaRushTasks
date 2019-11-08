package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<FileInputStream> list1 = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            list.add(args[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            list1.add(new FileInputStream(list.get(i)));
        }
        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(list1)));
        FileOutputStream fos = new FileOutputStream(resultFileName);
        ZipEntry zipEntry = zis.getNextEntry();
        byte[] buffer = new byte [100000];
        int byteBuffer;
        while ((byteBuffer = zis.read(buffer)) != -1) {
            fos.write(buffer, 0, byteBuffer);
        }
        zis.close();
        fos.close();
    }
}
