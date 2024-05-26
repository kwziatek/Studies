module app.inna_wersja {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens app.inna_wersja to javafx.fxml;
    exports app.inna_wersja;
}