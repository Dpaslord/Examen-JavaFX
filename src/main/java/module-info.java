module org.example.examenfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens org.example.examenfx to javafx.fxml;
    exports org.example.examenfx;
    opens org.example.examenfx.model to javafx.fxml;
    exports org.example.examenfx.model;
    opens org.example.examenfx.utils to javafx.fxml;
    exports org.example.examenfx.utils;
    exports org.example.examenfx.controller;
    opens org.example.examenfx.controller to javafx.fxml;

}