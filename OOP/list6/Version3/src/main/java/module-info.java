module app.version3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.version3 to javafx.fxml;
    exports app.version3;
}