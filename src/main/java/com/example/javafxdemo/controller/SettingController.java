package com.example.javafxdemo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;

public class SettingsController {
    @FXML
    private ChoiceBox<String> colorChoiceBox;

    @FXML
    private Slider fontSizeSlider;

    @FXML
    private CheckBox enableFeatureCheckbox;

    @FXML
    private Label messageLabel; // Added Label for displaying the message

    private String selectedColor;
    private double selectedFontSize;
    private boolean featureEnabled;

    public void initializeSettings() {
        // Initialize settings (e.g., read from a configuration file or preferences)
        selectedColor = "Red";
        selectedFontSize = 16.0;
        featureEnabled = false;

        // Set the UI components to reflect the initial settings
        colorChoiceBox.setValue(selectedColor);
        fontSizeSlider.setValue(selectedFontSize);
        enableFeatureCheckbox.setSelected(featureEnabled);
    }

    @FXML
    private void handleEnableFeatureCheckbox(ActionEvent event) {
        featureEnabled = enableFeatureCheckbox.isSelected();
    }

    @FXML
    private void handleSaveButton(ActionEvent event) {
        // Get the selected values from UI components
        selectedColor = colorChoiceBox.getValue();
        selectedFontSize = fontSizeSlider.getValue();
        featureEnabled = enableFeatureCheckbox.isSelected();

        // Update the message label with the selected color and font size
        messageLabel.setText("Selected Color: " + selectedColor + ", Selected Font Size: " + selectedFontSize);

        // Apply the selected settings (e.g., save to a configuration file or preferences)
        // You can implement the logic to save and apply the settings here

        // For example, you can print the selected settings to the console
        System.out.println("Selected Color: " + selectedColor);
        System.out.println("Selected Font Size: " + selectedFontSize);
        System.out.println("Feature Enabled: " + featureEnabled);
    }

    @FXML
    private void handleResetButton(ActionEvent event) {
        // Reset the UI components to their initial values
        colorChoiceBox.setValue(selectedColor);
        fontSizeSlider.setValue(selectedFontSize);
        enableFeatureCheckbox.setSelected(featureEnabled);

        // Clear the message label
        messageLabel.setText("");
    }
}