package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import javax.swing.text.StyledEditorKit;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> set = new HashSet<String>();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");
        for (String s :
                set) {
            System.out.println(s);
        }
    }
}
