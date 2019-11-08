package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {
        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        static BufferedReader b;
        ArrayList<String> list = new ArrayList<>();

        @Override
        public void setFileName(String fullFileName) {
            try {
                b = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {
            String s = "";
            for (String s1 : list) {
                s += s1 + " ";
            }
            return s;
        }

        @Override
        public void run() {
            try {
                if (b.ready()) {
                    String s;
                    while ((s = b.readLine()) != null) {
                        list.add(s);
                    }
                    b.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
