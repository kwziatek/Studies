module app.version {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.version to javafx.fxml;
    exports app.version;
}