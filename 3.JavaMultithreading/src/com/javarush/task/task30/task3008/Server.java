package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не было отправлено");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(ConsoleHelper.readInt());
        System.out.println("Сервер запущен");
        try {
            while (true) {
                new Handler(socket.accept()).start();
            }
        } catch (IOException e) {
            socket.close();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удалённым адресом");
            }
        }

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData())));
                } else {
                    ConsoleHelper.writeMessage("Это не текст");
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String s : connectionMap.keySet()) {
                if (!s.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, s));
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя"));
                message = connection.receive();
                if (message.getType().equals(MessageType.USER_NAME)
                        && !message.getData().isEmpty()
                        && !connectionMap.containsKey(message.getData())) {
                    break;
                }
            }
            connectionMap.put(message.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, "Имя было принято"));
            return message.getData();
        }
    }
}