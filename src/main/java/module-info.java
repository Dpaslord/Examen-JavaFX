module org.example.examenfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.examenfx to javafx.fxml;
    exports org.example.examenfx;
}