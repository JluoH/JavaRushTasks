package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {
    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }
        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());
        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());
        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = () -> System.out.println(Thread.currentThread().getName());
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private static AtomicInteger numFact = new AtomicInteger();
        private AtomicInteger numThread = new AtomicInteger();
        private AtomicInteger buff = new AtomicInteger();

        public AmigoThreadFactory() {
            buff.set(numFact.incrementAndGet());
        }

        @Override
        public Thread newThread(Runnable r) {
            synchronized (this) {
                Thread thread = new Thread(r);
                thread.setDaemon(false);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName(String.format("%s-pool-%s-thread-%s", Thread.currentThread().getThreadGroup().getName(), buff.get(), numThread.incrementAndGet()));
                return thread;
            }
        }
    }
}
