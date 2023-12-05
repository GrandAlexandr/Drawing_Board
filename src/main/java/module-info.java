module com.example.drawing_board {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawing_board to javafx.fxml;
    exports com.example.drawing_board;
}