package com.hifi.model;

import java.sql.Timestamp;

public class Message {
    private int id;
    private int userId;
    private String username;
    private String text;
    private Timestamp createdAt;

    public Message() {}

    public Message(int id, int userId, String username, String text, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.text = text;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getText() { return text; }
    public Timestamp getCreatedAt() { return createdAt; }
}
