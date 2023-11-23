package com.example.javafxdemo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultViewController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label nationalityLabel;

    @FXML
    private Label correctAnswersLabel;

    @FXML
    private Label incorrectAnswersLabel;

    public void initialize(String name, String nationality, int correctAnswers, int incorrectAnswers) {
        nameLabel.setText("Name: " + name);
        nationalityLabel.setText("Nationality: " + nationality);
        correctAnswersLabel.setText("Correct Answers: " + correctAnswers);
        incorrectAnswersLabel.setText("Incorrect Answers: " + incorrectAnswers);
    }
}
