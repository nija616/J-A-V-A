package com.example.javafxdemo.controller;

import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DashboardController {
    @FXML
    private Label accountNameText;

    @FXML
    private Label NationalityText;

    @FXML
    private Label AddressText;

    @FXML
    private ImageView profileImage;

    @FXML
    private ListView<String> notificationListView;

    public void setAccountName(String accountName) {
        accountNameText.setText(" " + accountName);
    }

    public void setNationality(String nationality) {
        NationalityText.setText("Nationality: " + nationality);
    }

    public void setAddressText(String address) {
        AddressText.setText("Address: " + address);
    }

    @FXML
    private void playQuizButtonClicked(ActionEvent event) {

    }

    @FXML
    private void changeProfilePicture(ActionEvent event) {
        // Implement the logic for changing the profile picture here
    }

    @FXML
    private void openSettingsDialog(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javafxdemo/settings-dialog.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Settings");
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void navigateToHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javafxdemo/dashboard-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) accountNameText.getScene().getWindow(); // Get the current stage
            stage.setTitle("Dashboard");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/com/example/javafxdemo/css/dashboard.css").toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateNotifications(List<String> notifications) {
        notificationListView.getItems().addAll(notifications);
    }
    @FXML
    private void loadSampleQuestions(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javafxdemo/sample.fxml"));
            Parent root = loader.load();

            // Load questions from a CSV file and populate your sample questions
            // You can use a ListView to display the questions

            ListView<String> sampleQuestionListView = (ListView<String>) root.lookup("#sampleQuestionListView");
            if (sampleQuestionListView != null) {
                sampleQuestionListView.getItems().clear(); // Clear any previous items

                // Sample code for reading CSV using OpenCSV:
                CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/quiz_question.csv"));
                List<String[]> csvData = csvReader.readAll();

                // Process the CSV data and load questions into the ListView
                for (String[] row : csvData) {
                    // Assuming CSV columns are in a specific order, e.g., question, option1, option2, option3, option4, correctAnswer
                    String question = row[0];
                    sampleQuestionListView.getItems().add(question);
                }

                // Close the CSV reader
                csvReader.close();
            }

            Stage stage = new Stage();
            stage.setTitle("Sample Questions");
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void LoadResults(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javafxdemo/result-view.fxml"));
            Parent root = loader.load();

            // Get the ListView from the loaded FXML file
            ListView<String> resultsViewList = (ListView<String>) root.lookup("#resultsViewList");

            // Check if the ListView is found
            if (resultsViewList != null) {
                // Clear any previous items in the ListView
                resultsViewList.getItems().clear();

                // Sample code for reading CSV using OpenCSV:
                CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/results.csv"));
                List<String[]> csvData = csvReader.readAll();

                // Process the CSV data and load questions into the ListView
                for (String[] row : csvData) {
                    // Assuming CSV columns are in a specific order, e.g., question, answer
                    String question = row[0];
                    String answer = row[1];
                    resultsViewList.getItems().add("Name: " + question + ", Score: " + answer);
                }

                // Close the CSV reader
                csvReader.close();
            } else {
                // Print an error message if the ListView is not found
                System.err.println("ListView not found in result-view.fxml");
            }

            // Create a new stage for displaying the results
            Stage stage = new Stage();
            stage.setTitle("Results");
            Scene scene = new Scene(root);

            // Set the scene for the stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Print the stack trace in case of an IOException
            e.printStackTrace();
        } catch (Exception e) {
            // Print the stack trace for any other exceptions
            e.printStackTrace();
        }
    }


}