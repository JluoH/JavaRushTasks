package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {

    transient private FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName  = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);
        stream.write("keks".getBytes());
        stream.flush();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("C:\\Users\\evilr\\3D Objects\\Desktop\\F1.TXT");
        solution.writeObject("Kekmund");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\evilr\\3D Objects\\Desktop\\F2.TXT");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(solution);
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\evilr\\3D Objects\\Desktop\\F2.TXT");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution solution1 = (Solution) objectInputStream.readObject();
    }
}
