module app.edytor_graficzny {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens app.edytor_graficzny to javafx.fxml;
    exports app.edytor_graficzny;
}