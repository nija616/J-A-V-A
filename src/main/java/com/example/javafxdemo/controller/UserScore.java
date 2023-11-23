package com.example.javafxdemo.controller;
public class UserScore {
    private String userName;
    private int score;

    public UserScore(String userName, int score) {
        this.userName = userName;
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public int getScore() {
        return score;
    }
}