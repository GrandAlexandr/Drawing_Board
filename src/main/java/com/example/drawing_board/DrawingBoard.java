package com.example.drawing_board;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DrawingBoard extends Application {
    public Canvas canvas;
    private GraphicsContext gc;
    private ColorPicker colorPicker;
    private Slider slider;
    public void start (Stage primaryStage) {
        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        colorPicker = new ColorPicker();
        slider = new Slider(1,20,5);
        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(colorPicker);
        root.setTop(slider);
        colorPicker.setOnAction(e -> gc.setStroke(colorPicker.getValue()));
        slider.setOnMouseDragged(e -> gc.setLineWidth(slider.getValue()));
        canvas.setOnMousePressed(e -> {
            gc.beginPath();
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
        });
        canvas.setOnMouseDragged(e ->{
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
        });
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Рисовахи");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}