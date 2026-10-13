module org.example.imageball {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.imageball to javafx.fxml;
    exports org.example.imageball;
}