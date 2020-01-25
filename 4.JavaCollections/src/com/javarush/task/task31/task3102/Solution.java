package com.javarush.task.task31.task3102;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<File> list = new ArrayList();
        File file = new File(root);
        File[] mass = file.listFiles();
        Collections.addAll(list, mass);
        ArrayList<String> kek = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).isFile()) {
                kek.add(list.get(i).getAbsolutePath());
            } else if (list.get(i).isDirectory()) {
                File[] f = list.get(i).listFiles();
                Collections.addAll(list, f);
            }
            i++;
        }
        return kek;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1221); //порт
//в цикле обрабатываем входящие соединения.
        while (true) {
            //метод accept ждет, пока кто-то не подключится.
            Socket socket = serverSocket.accept();
            //читаем сообщение
            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String message = in.readLine();
            //придумываем ответ – просто разворачиваем строку задом наперед
            String reverseMessage = new StringBuilder(message).reverse().toString();
            //отправляем ответ
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println(reverseMessage);
        }
    }
}
