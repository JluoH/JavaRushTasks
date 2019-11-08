package com.javarush.task.task30.task3013;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));
        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
        System.out.println();
        int i = 1;
        System.out.print(i + " ");
        System.out.println(String.format("00000000000000000000000%s", Integer.toString(i, 2)));
        int x = solution.resetLowerBits(i);
        System.out.print(x + " ");
        System.out.println(Integer.toString(x, 2));
    }

    public int resetLowerBits(int number) {
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 4;
        number |= number >> 8;
        number |= number >> 16;
        number = number & ~(number >> 1);
        return number;
    }
}