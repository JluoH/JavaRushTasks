package com.javarush.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    public static void main(String[] args) {
        System.out.println(Thread.State.BLOCKED.ordinal());
    }
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        try {

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    SocketTask.this.cancel();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    super.cancel(mayInterruptIfRunning);
                    return false;
                }
            }
        };
    }
}