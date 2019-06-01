package com.example.stuff_14;

import java.util.UUID;

public class Change_Username {
    private String username;
    public static final String GetID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}