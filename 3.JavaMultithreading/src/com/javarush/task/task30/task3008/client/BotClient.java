package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public static void main(String[] args) {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(": ")) {
                return;
            }
            String[] split = message.split(": ");
            String s = split[1];
            SimpleDateFormat simpleDateFormat = null;
            String text = null;
            switch (s) {
                case "дата":
                    simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                    break;
                case "день":
                    simpleDateFormat = new SimpleDateFormat("d");
                    break;
                case "месяц":
                    simpleDateFormat = new SimpleDateFormat("MMMM");
                    break;
                case "год":
                    simpleDateFormat = new SimpleDateFormat("YYYY");
                    break;
                case "время":
                    simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                    break;
                case "час":
                    simpleDateFormat = new SimpleDateFormat("H");
                    break;
                case "минуты":
                    simpleDateFormat = new SimpleDateFormat("m");
                    break;
                case "секунды":
                    simpleDateFormat = new SimpleDateFormat("s");
                    break;
            }
            if (simpleDateFormat != null) {
                text = simpleDateFormat.format(new GregorianCalendar().getTime());
                sendTextMessage("Информация для " + split[0] + ": " + text);
            }
        }
    }
}
