package com.javarush.task.task20.task2015;

import com.javarush.task.task14.task1409.Bridge;

import java.io.*;

public class Solution implements Serializable {

    private int x;
    private int y;
    private String s;

    public static void main(String[] args) throws FileNotFoundException {
        Solution solution = new Solution();
        solution.x = 100;
        solution.y = 200;
        solution.s = "Maslik";
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\evilr\\3D Objects\\Desktop\\F1.TXT");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\evilr\\3D Objects\\Desktop\\F1.TXT");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Bridge solution1 = (Bridge) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
