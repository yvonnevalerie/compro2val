package com.game;

import java.net.Socket;

public class Player {
    private String userName;
    private int score;
    private Socket connection;

    public Player(String userName, int score, Socket connection) {
        this.userName = userName;
        this.score = score;
        this.connection = connection;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Socket getConnection() {
        return connection;
    }

    public void setConnection(Socket connection) {
        this.connection = connection;
    }
}
