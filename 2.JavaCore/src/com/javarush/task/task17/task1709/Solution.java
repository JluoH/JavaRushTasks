package com.javarush.task.task17.task1709;

/* 
Предложения
*/

public class Solution {

    public static volatile int proposal = 0;

    public static void main(String[] args) {
        new AcceptProposal().start();
        new MakeProposal().start();
    }

    public static class MakeProposal extends Thread {

        @Override
        public void run() {
            int thisProposal = proposal;
            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1)+ " поток 1");
                proposal = ++thisProposal;
                Thread.yield();
            }
        }
    }

    public static class AcceptProposal extends Thread {

        @Override
        public void run() {
            int thisProposal = proposal;
            while (thisProposal < 10) {
                if (thisProposal != proposal) {
                    System.out.println("Принято предложение №" + proposal);
                    thisProposal = proposal;
                }
            }
        }
    }
}
