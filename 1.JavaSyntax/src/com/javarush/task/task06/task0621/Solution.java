package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName);
        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName);

        String papa = reader.readLine();
        Cat papa1 = new Cat(papa, null, catFather);

        String mama = reader.readLine();
        Cat mama1 = new Cat(mama, catMother);
        String syn = reader.readLine();
        Cat syn1 = new Cat(syn, mama1, papa1);
        String do4 = reader.readLine();
        Cat do41 = new Cat(do4, mama1, papa1);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(papa1);
        System.out.println(mama1);
        System.out.println(syn1);
        System.out.println(do41);
    }

    public static class Cat {
        private String name;
        private Cat parent;
        private Cat parent1;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent) {
            this.name = name;
            this.parent = parent;
        }

        Cat(String name, Cat parent, Cat parent1) {
            this.name = name;
            this.parent = parent;
            this.parent1 = parent1;
        }


        @Override
        public String toString() {
            if (parent != null && parent1 != null) {
                return "The cat's name is " + name + ", mother is " + parent.name + ", father is " + parent1.name;
            } else if (parent != null)
                return "The cat's name is " + name + ", mother is " + parent.name + ", no father";
            else if (parent1 != null)
                return "The cat's name is " + name + ", no mother, father is " + parent1.name;
                return "The cat's name is " + name + ", no mother, no father";
        }
    }
}
