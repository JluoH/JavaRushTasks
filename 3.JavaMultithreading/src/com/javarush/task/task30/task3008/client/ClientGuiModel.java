package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClientGuiModel {
    private final Set<String> allUserNames = new LinkedHashSet<>();
    private String newMessage;

    public void addUser(String newUserName) {
        allUserNames.add(newUserName);
    }

    public void deleteUser(String newUserName) {
        allUserNames.remove(newUserName);
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }
}
