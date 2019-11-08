package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        int i = 1;
        System.out.println(String.format("%02x", i));
        System.out.println(Integer.toHexString(i));
    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] mass = md.digest(byteArrayOutputStream.toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : mass) {
            sb.append(String.format("%02X", b));
        }
        System.out.println(sb.toString().toLowerCase());
        return sb.toString().toLowerCase().equals(md5);
    }
}
