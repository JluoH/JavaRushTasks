package com.javarush.task.task21.task2101;

/*
Определяем адрес сети
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(Byte.toUnsignedInt((byte) -1));
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] bytes = new byte[ip.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (ip[i] & mask[i]);
        }
        return bytes;
    }

    public static void print(byte[] bytes) {
        for (byte aByte : bytes) {
            System.out.print(Byte.toUnsignedInt(aByte) + " ");
        }
        System.out.println();
    }
}
