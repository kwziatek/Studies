module app.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens app.demo1 to javafx.fxml;
    exports app.demo1;
}