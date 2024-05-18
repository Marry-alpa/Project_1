package com.example.project_1.project1_2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.util.Random;
import javafx.geometry.Pos;

public class project1_2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            VBox root = new VBox(20);
            root.setPadding(new Insets(20));

            HBox buttons = new HBox(20);
            Button button1 = new Button("GridPane");
            Button button2 = new Button("Pane");
            buttons.getChildren().addAll(button1, button2);
            button1.setOnAction(e -> showGridPane(root));
            button2.setOnAction(e -> showPane(root));

            root.getChildren().add(buttons);
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Layouts");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Color generateRandomColor() {
        Random rand = new Random();
        double r = rand.nextDouble();
        double g = rand.nextDouble();
        double b = rand.nextDouble();
        return Color.color(r, g, b);
    }

    private void showGridPane(VBox box) {
        // removing all children except the buttons
        if (box.getChildren().size() > 1) {
            box.getChildren().remove(1, box.getChildren().size());
        }

        // creating a GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPrefSize(180, 180);

        // creating more controls
        HBox controls = new HBox(20);
        Button button1 = new Button("Background");
        Button button2 = new Button("Alignment");
        controls.getChildren().addAll(button1, button2);

        int[] alignment = {0};
        button1.setOnAction(e -> {
            if (gridPane.getStyle().equals("-fx-background-color: black;")) {
                gridPane.setStyle("-fx-background-color: white;");
            } else {
                gridPane.setStyle("-fx-background-color: black;");
            }
        });

        button2.setOnAction(e -> {
            alignment[0] = (alignment[0] + 1) % 3;
            if (alignment[0] == 0) {
                gridPane.setAlignment(Pos.TOP_LEFT);
            } else if (alignment[0] == 1) {
                gridPane.setAlignment(Pos.CENTER);
            } else {
                gridPane.setAlignment(Pos.TOP_RIGHT);
            }
        });

        for (int i = 0; i < 5; i++) {
            Color circleColor = generateRandomColor();
            for (int j = 0; j < 5; j++) {
                Circle circle = new Circle(20, circleColor);
                circle.setOpacity(0.2 * (j + 1));
                gridPane.add(circle, j, i);
            }
        }

        box.getChildren().addAll(controls, gridPane);
    }

    private void showPane(VBox box) {
        // removing all children except the buttons
        if (box.getChildren().size() > 1) {
            box.getChildren().remove(1, box.getChildren().size());
        }

        // creating a Pane
        double x = 0;
        double y = 0;
        double hPhone = 300;
        double wPhone = 150;

        Pane pane = new Pane();
        pane.setPrefSize(500, 500);
        Rectangle base = new Rectangle(x, y, wPhone, hPhone);
        base.setFill(Color.LIGHTBLUE);
        base.setStroke(Color.BLACK);

        double hBorders = 30;
        Rectangle top = new Rectangle(x, y, wPhone, hBorders);
        Rectangle bottom = new Rectangle(x, hPhone + y - hBorders, wPhone, hBorders);
        top.setFill(Color.BLACK);
        bottom.setFill(Color.BLACK);

        double buttonRadius = (hBorders - 10) / 2;
        Circle button = new Circle(wPhone / 2 + x, hPhone - buttonRadius - 5 + y, buttonRadius);
        button.setFill(Color.WHITE);

        Ellipse camera = new Ellipse(wPhone / 2 + x, hBorders / 2 + y, (hBorders - 18) / 2 + 9, (hBorders - 18) / 2);
        camera.setFill(Color.GRAY);
        camera.setStroke(Color.WHITE);
        camera.setStrokeWidth(2);

        double importantValue = (wPhone - 20) / 4; // value for polyline building
        Text text = new Text(wPhone / 2 + x - 30, hPhone / 2 + y, "Welcome!");
        Line line = new Line(x + 10, hPhone / 2 + y - 40, x + wPhone - 10, hPhone / 2 + y - 40);
        line.setStrokeWidth(3);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        line.getStrokeDashArray().addAll(10.0, 20.0);

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(new Double[]{
                x + 10, hPhone / 2 + y + 40,
                x + 10 + importantValue, hPhone / 2 + y + 20,
                x + 10 + importantValue * 2, hPhone / 2 + y + 40,
                x + 10 + importantValue * 3, hPhone / 2 + y + 20,
                x + 10 + importantValue * 4, hPhone / 2 + y + 40
        });
        polyline.setStrokeWidth(3);

        pane.getChildren().addAll(base, top, bottom, button, camera, text, line, polyline);
        box.getChildren().add(pane);
    }
}
