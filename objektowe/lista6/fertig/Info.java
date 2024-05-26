/**
 * @file Info.java
 * @brief Klasa Info dziedzicząca po MenuItem, która tworzy okno dialogowe typu Alert z informacjami o projekcie
 */
package app.demo1;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
/**
 * Klasa Info dziedzicząca po MenuItem, która tworzy okno dialogowe typu Alert z informacjami o projekcie
 * @class Info
 * @details Klasa Info dziedzicząca po MenuItem, która tworzy okno dialogowe typu Alert z informacjami o projekcie
 * @brief Klasa Info dziedzicząca po MenuItem, która tworzy okno dialogowe typu Alert z informacjami o projekcie
 * */
public class Info extends MenuItem {
    public Info(){
        super("Info");
        initialize();
    }
/**
 * Metoda initialize() tworząca okno dialogowe typu Alert z informacjami o projekcie
 * @fn private void initialize()
 * @brief Metoda initialize() tworząca okno dialogowe typu Alert z informacjami o projekcie
 * */
    private void initialize(){
        setOnAction(e -> {
            // Tworzenie okienka dialogowego typu Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Info");
            alert.setContentText("Project name: Graphic editor \nAuthor: Karol Wziątek\nPurpose: Project was created for OOP course to be graded \nFunctionality: Geometric figures drawing, adjusting their colour and size, rotating them, saving them to a file and loading back");

            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    alert.close();
                }
            });
        });
    }

}
