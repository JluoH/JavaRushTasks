package com.javarush.task.task14.task1402;

/* 
Bingo-2!
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat = new TomCat();
        TomCat c = (TomCat) cat;
        c.heh();

    }



    static class Cat {
    }

    static class TomCat extends Cat {
   void heh(){
       System.out.println("heh");
   }
    }
}
