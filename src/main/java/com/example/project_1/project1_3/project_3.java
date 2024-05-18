
package com.example.project_1.project1_3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

import java.io.*;

class Student{
    public String name;
    public String surname;
    public String date;
    public String month;
    public String year;
    public String email;
    public String phoneNumber;
    public String program;
    public String[] NMT = new String[3];
    public String thirdSubject;
    public String englishTest;
    public String motivation;

}
public class project_3 extends Application {

    private final Student[] students = new Student[100];
    private Student sampleStudent = readFromFile();

    private int studentIndex = 0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));

        page1(root, 0);

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("AUK Application Form");
        stage.show();
    }

    private void page1(VBox root, int index){
        students[index] = new Student();
        Label titleLabel = new Label("Please fill in basic information about yourself:");
        root.getChildren().add(titleLabel);
        Button load1 = new Button("Load");
        Button load2 = new Button("Load");
        Button load3 = new Button("Load");
        Button load4 = new Button("Load");
        Button load5 = new Button("Load");
        Button load = new Button("Load ");

        load.setOnAction(e -> {
            load1.getOnAction().handle(e);
            load2.getOnAction().handle(e);
            load3.getOnAction().handle(e);
            load4.getOnAction().handle(e);
            load5.getOnAction().handle(e);
        });

        //name and surname
        getNameAndSurname(root, students[index], load1);

        //date of birth
        getDateOfBirth(root, students[index], load2);

        //email
        getEmail(root, students[index], load3);

        //phone number
        getPhoneNumber(root, students[index], load4);

        Button submitButton = new Button("Submit");
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(submitButton, load);
        submitButton.setOnAction(e -> submit1(root, students[index]));
        root.getChildren().addAll(buttonBox);
    }

    private void getNameAndSurname(VBox root, Student student, Button load){
        Label nameLabel = new Label("Name and surname:");
        HBox nameRow = new HBox(10);
        TextField nameField = new TextField();
        TextField surnameField = new TextField();
        nameField.setPromptText("Vasya");
        surnameField.setPromptText("Pupkin");
        nameRow.getChildren().addAll(nameLabel, nameField, surnameField);
        root.getChildren().add(nameRow);

        load.setOnAction(e -> {
            nameField.setText(sampleStudent.name);
            surnameField.setText(sampleStudent.surname);
        });

        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.name = newValue;
        });

        surnameField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.surname = newValue;
        });
    }

    private void getDateOfBirth(VBox root, Student student, Button load){
        Label dateLabel = new Label("Date of birth:");
        HBox dateRow = new HBox(10);
        TextField dateField = new TextField();
        TextField monthField = new TextField();
        TextField yearField = new TextField();
        dateField.setPromptText("dd");
        monthField.setPromptText("mm");
        yearField.setPromptText("yyyy");
        dateRow.getChildren().addAll(dateLabel, dateField, monthField, yearField);
        root.getChildren().add(dateRow);

        load.setOnAction(e -> {
            dateField.setText(sampleStudent.date);
            monthField.setText(sampleStudent.month);
            yearField.setText(sampleStudent.year);
        });

        dateField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.date = newValue;
        });

        monthField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.month =newValue;
        });

        yearField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.year = newValue;
        });
    }

    private void getEmail(VBox root, Student student, Button load) {
        HBox emailRow = new HBox(10);
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setPromptText("user@gmail.com");
        emailRow.getChildren().addAll(emailLabel, emailField);
        root.getChildren().add(emailRow);

        load.setOnAction(
                e -> emailField.setText(sampleStudent.email)
        );

        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.email = newValue;
        });
    }

    private void getPhoneNumber(VBox root, Student student, Button load) {
        HBox phoneRow = new HBox(10);
        Label phoneLabel = new Label("Phone number:");
        TextField phoneField = new TextField();
        phoneField.setPromptText("+380501234567");
        phoneRow.getChildren().addAll(phoneLabel, phoneField);
        root.getChildren().add(phoneRow);

        load.setOnAction(
                e -> phoneField.setText(sampleStudent.phoneNumber)
        );

        phoneField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.phoneNumber = newValue;
        });
    }

    private void submit1(VBox root, Student student){
        VBox mistakeBox = new VBox(10);
        mistakeBox.getChildren().add(new Label("Please fix errors which occurred:"));
        try {
            int date = Integer.parseInt(student.date);
            if (date < 1 || date > 31) {
                Label mistake = new Label("Date of birth does not exist");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);

            }
        }
        catch (NumberFormatException e){
            if (student.date == null){
                Label mistake = new Label("Date of birth is not filled");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
            else{
                Label mistake = new Label("Date of birth is not a number");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
        }

        try {
            int date = Integer.parseInt(student.month);
            if (date < 1 || date > 12) {
                Label mistake = new Label("Month of birth does not exist");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
        }
        catch (NumberFormatException e){
            if (student.month == null){
                Label mistake = new Label("Month of birth is not filled");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
            else{
                Label mistake = new Label("Month of birth is not a number");
                mistakeBox.getChildren().add(mistake);
                mistake.setTextFill(Color.RED);}
        }

        try {
            int date = Integer.parseInt(student.year);
            if (date < 1900 || date > 2024) {
                Label mistake = new Label("Year of birth does not exist");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
        }
        catch (NumberFormatException e){
            if (student.year == null){
                Label mistake = new Label("Year of birth is not filled");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
            else{
                Label mistake = new Label("Year of birth is not a number");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);}
        }

        if (student.email == null){
            Label mistake = new Label("Email is not filled");
            mistake.setTextFill(Color.RED);
            mistakeBox.getChildren().add(mistake);
        }
        else if (!student.email.contains("@")){
            Label mistake = new Label("Email is not correct");
            mistake.setTextFill(Color.RED);
            mistakeBox.getChildren().add(mistake);
        }

        if(student.phoneNumber!=null && student.phoneNumber.length() != 13){
            Label mistake = new Label("Phone number is not correct");
            mistake.setTextFill(Color.RED);
            mistakeBox.getChildren().add(mistake);
        }


        if (student.name == null){
            Label mistake = new Label("Name is not filled");
            mistake.setTextFill(Color.RED);
            mistakeBox.getChildren().add(mistake);
        }

        if (student.surname == null){
            Label mistake = new Label("Surname is not filled");
            mistake.setTextFill(Color.RED);
            mistakeBox.getChildren().add(mistake);
        }


        if (mistakeBox.getChildren().size()==1){
            page2(root, student);
        }
        else if (root.getChildren().size()==9){
            root.getChildren().remove(8);
            root.getChildren().add( mistakeBox);
        }
        else{
            root.getChildren().add(mistakeBox);
        }
    }

    private void page2(VBox root, Student student){
        root.getChildren().clear();
        Label titleLabel = new Label("Please fill in additional details about you:");
        root.getChildren().add(titleLabel);
        Button load1 = new Button();
        Button load2 = new Button();
        Button load3 = new Button();
        Button load = new Button("Load");

        getProgram(root, student);
        getNMT(root,student, load1);
        getEnglish(root, student, load2);
        getMotivationLetter(root, student, load3);

        load.setOnAction(e -> {
            load1.getOnAction().handle(e);
            load2.getOnAction().handle(e);
            load3.getOnAction().handle(e);
        });

        Button button = new Button("Submit");
        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(load, button);
        button.setOnAction(e -> submit2(root, student));
        root.getChildren().add(buttons);
    }

    private void getProgram(VBox root, Student student){
        HBox programRow = new HBox(10);
        Label programLabel = new Label("Choose program:");
        ComboBox<String> programBox = new ComboBox<>();
        programBox.getItems().addAll("Software Engineering", "Data Science", "Marketing", "Business Administration", "Global Management");
        programRow.getChildren().addAll(programLabel, programBox);
        root.getChildren().add(programRow);

        programBox.setOnAction(e -> {
            student.program = programBox.getValue();
        });
    }

    private void getNMT(VBox root, Student student, Button load){
        HBox ukrainianRow = new HBox(10);
        HBox mathsRow = new HBox(10);
        HBox anotherRow = new HBox(10);
        Label nmtLabel = new Label("Enter NMT score:");
        root.getChildren().add(nmtLabel);
        ukrainianRow.getChildren().add(new Label("Ukrainian: "));
        TextField ukrainianField = new TextField();
        ukrainianRow.getChildren().add(ukrainianField);
        mathsRow.getChildren().add(new Label("Maths: "));
        TextField mathsField = new TextField();
        mathsRow.getChildren().add(mathsField);
        root.getChildren().addAll(ukrainianRow, mathsRow);
        ComboBox<String> anotherBox = new ComboBox<>();
        anotherBox.getItems().addAll("English", "History", "Biology", "Chemistry", "Physics", "Geography");
        anotherBox.setOnAction(e -> {
            student.thirdSubject = anotherBox.getValue();
        });
        TextField anotherField = new TextField();
        anotherRow.getChildren().addAll(new Label("Third subject: "), anotherBox, anotherField);
        root.getChildren().add(anotherRow);

        load.setOnAction(e -> {
            ukrainianField.setText(sampleStudent.NMT[0]);
            mathsField.setText(sampleStudent.NMT[1]);
            anotherField.setText(sampleStudent.NMT[2]);
        });

        ukrainianField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.NMT[0] = newValue;
        });

        mathsField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.NMT[1] = newValue;
        });

        anotherField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.NMT[2] = newValue;
        });
    }

    private void getEnglish(VBox root, Student student, Button load){
        HBox englishRow = new HBox(10);
        englishRow.getChildren().add(new Label("English test result: "));
        TextField englishField = new TextField();
        englishRow.getChildren().add(englishField);
        root.getChildren().add(englishRow);

        load.setOnAction(
                e -> englishField.setText(sampleStudent.englishTest)
        );

        englishField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.englishTest = newValue;
        });
    }

    private void getMotivationLetter(VBox root, Student student, Button load){
        root.getChildren().add(new Label("Motivation letter: "));
        TextArea motivationField = new TextArea();
        root.getChildren().add(motivationField);

        load.setOnAction(
                e -> motivationField.setText(sampleStudent.motivation)
        );

        motivationField.textProperty().addListener((observable, oldValue, newValue) -> {
            student.motivation = newValue;
        });
    }

    private void submit2(VBox root, Student student){
        VBox mistakeBox = new VBox(10);
        mistakeBox.getChildren().add(new Label("Please fix errors which occurred:"));

        try{
            int ukrainian = Integer.parseInt(student.NMT[0]);
            if (ukrainian < 100 || ukrainian > 200){
                Label mistake = new Label("Ukrainian NMT score is not correct");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
        }catch (NumberFormatException e){
            if (student.NMT[0] == null){
                Label mistake = new Label("Ukrainian NMT score is not filled");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
            else{
                Label mistake = new Label("Ukrainian NMT score is not a number");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);}
        }

        try{
            int maths = Integer.parseInt(student.NMT[1]);
            if (maths < 100 || maths > 200){
                Label mistake = new Label("Maths NMT score is not correct");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
        }catch (NumberFormatException e){
            if (student.NMT[1] == null){
                Label mistake = new Label("Maths NMT score is not filled");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
            else{
                Label mistake = new Label("Maths NMT score is not a number");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);}
        }
        try{
            int third = Integer.parseInt(student.NMT[2]);
            if (third < 100 || third > 200){
                Label mistake = new Label("Third NMT score is not correct");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
        }catch (NumberFormatException e){
            if (student.NMT[2] == null){
                Label mistake = new Label("Third NMT score is not filled");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
            else{
                Label mistake = new Label("Third NMT score is not a number");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);}
        }
        try{
            int english = Integer.parseInt(student.englishTest);
        }catch (NumberFormatException e){
            if (student.englishTest == null){
                Label mistake = new Label("English test result is not filled");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
            else{
                Label mistake = new Label("English test result is not a number");
                mistake.setTextFill(Color.RED);
                mistakeBox.getChildren().add(mistake);
            }
        }

        if (student.motivation == null){
            Label mistake = new Label("Motivation letter is not filled");
            mistake.setTextFill(Color.RED);
            mistakeBox.getChildren().add(mistake);
        }

        if (root.getChildren().size()==11 && mistakeBox.getChildren().size()!=1){
            root.getChildren().remove(10);
            root.getChildren().add(mistakeBox);
        }
        else if (mistakeBox.getChildren().size()==1){
            page3(root, student);
        }
        else{
            root.getChildren().add(mistakeBox);
        }
    }

    private void page3(VBox root, Student student){
        root.getChildren().clear();
        root.getChildren().addAll(new Label("Thank you for filling in the form!"), new Label("Here is the information you provided:"));

        root.getChildren().add(new Label("Name: " + student.name + " " + student.surname));
        root.getChildren().add(new Label("Date of birth: " + student.date + "." + student.month + "." + student.year));
        root.getChildren().add(new Label("Email: " + student.email));
        root.getChildren().add(new Label("Phone number: " + student.phoneNumber));
        root.getChildren().add(new Label("Program: " + student.program));
        root.getChildren().add(new Label("NMT scores: Ukrainian - " + student.NMT[0] + ", Maths - " + student.NMT[1] + ", " + student.thirdSubject + " - " + student.NMT[2]));
        root.getChildren().add(new Label("English test result: " + student.englishTest));
        root.getChildren().add(new Label("Motivation letter: " + student.motivation));

        HBox buttonBox = new HBox(10);
        Button addButton = new Button("Fill form again");
        Button button = new Button("Save");
        buttonBox.getChildren().addAll(button, addButton);
        root.getChildren().add(buttonBox);
        button.setOnAction(e -> save(root, student));
        addButton.setOnAction(e -> {studentIndex++;
            root.getChildren().clear();
            page1(root, studentIndex);});
    }

    private void save(VBox root, Student student){
        try {
            File file = new File(String.format("%s_%s.txt", student.name, student.surname));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(student.name + "\n" + student.surname + "\n"+
                    student.date + "\n" + student.month + "\n" + student.year + "\n"+
                    student.email + "\n" + student.phoneNumber + "\n"+
                    student.program + "\n"+
                    student.NMT[0] + "\n" + student.NMT[1] + "\n" + student.NMT[2] + "\n"+
                    student.thirdSubject + "\n"+
                    student.englishTest + "\n"+
                    student.motivation + "\n");
            writer.close();
        }catch (IOException e){
            root.getChildren().add(new Label("An error occurred"));
        }
    }

    private Student readFromFile(){
        Student student = new Student();
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))){
            student.name = reader.readLine();
            student.surname = reader.readLine();
            student.date = reader.readLine();
            student.month = reader.readLine();
            student.year = reader.readLine();
            student.email = reader.readLine();
            student.phoneNumber = reader.readLine();
            student.program = reader.readLine();
            student.NMT[0] = reader.readLine();
            student.NMT[1] = reader.readLine();
            student.NMT[2] = reader.readLine();
            student.thirdSubject = reader.readLine();
            student.englishTest = reader.readLine();
        }catch (IOException e){
            return null;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader("sampleMotivation.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                student.motivation += line;
            }
        }catch (IOException e){
            return null;
        }
        return student;
    }
}
