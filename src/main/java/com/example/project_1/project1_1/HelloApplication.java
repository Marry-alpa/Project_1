package com.example.project_1.project1_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(30);
        root.setPadding(new Insets(25));

        HBox nameRow = new HBox(15);
        Label nameL = new Label("Name:");
        TextField nameF = new TextField();
        Button strButton = new Button("Strange, doctor Button Strange");
        nameRow.getChildren().addAll(nameL, nameF);

        HBox heroRow = new HBox(10);
        Label heroL = new Label("Choose a character:");

        ComboBox<String> heroB = new ComboBox<>();
        heroB.getItems().addAll("Iron man", "Capitan America", "Spider-man", "Deadpool", "Ant-man","Captain Marvel",
                "Black Panther","doctor Steven Strange", "I don't like heroes");
        heroRow.getChildren().addAll(heroL, heroB);

        TextArea textArea = new TextArea();
        strButton.setOnAction(e -> textArea.appendText(String.format("Did we say welcome, " + nameF.getText() + "?\n")));

        CheckBox checkBox = new CheckBox("Did you choose your hero?");
        checkBox.setDisable(true);

        Label radioLabel = new Label("Do you choose your heroes name?");
        RadioButton radioButton1 = new RadioButton("Yes");
        RadioButton radioButton2 = new RadioButton("No");
        ToggleGroup group = new ToggleGroup();
        radioButton1.setToggleGroup(group);
        radioButton2.setToggleGroup(group);

        radioButton1.setOnAction(e -> {
            if (nameF.getText().isEmpty()) {
                textArea.appendText("You didn't choose your name! \n");
                radioLabel.setText("You. Are. LIAR");
            } else {
                textArea.appendText("You choose your name!\n");
                radioLabel.setText("Welcome, " + nameL.getText()+ "!");
            }
        });

        radioButton2.setOnAction(
                e -> {
                    textArea.appendText("You didn't choose your name!\n");
                    radioLabel.setText("Please choose your name!");
                }
        );

        heroB.setOnAction(e -> {
            checkBox.setDisable(false);
            if (heroB.getValue().equals("I don't like heroes")) {
                checkBox.textProperty().setValue("What do you do here?");
            } else {
                checkBox.textProperty().setValue("Do you really love " + heroB.getValue() + "?");
            }
        });

        checkBox.setOnAction(e -> {
            if (checkBox.isSelected()) {
                textArea.appendText("You have confirmed your choice!\n");
            } else {
                textArea.appendText("You have not confirmed your choice!\n");
            }
        });


        root.getChildren().addAll(nameRow, strButton, heroRow, textArea, checkBox, radioLabel, radioButton1, radioButton2);
        stage.setScene(new Scene(root, 400, 500));
        stage.setTitle("Hero app");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}