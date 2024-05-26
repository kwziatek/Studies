/**
 * @file Guide.java
 * @brief Klasa Guide dziedzicząca po MenuItem, która tworzy okno dialogowe typu Alert z informacjami o obsłudze programu
 */
package app.demo1;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
/**
 * Klasa Guide dziedzicząca po MenuItem, która tworzy okno dialogowe typu Alert z informacjami o obsłudze programu
 * @class Guide
 * @details Klasa Guide dziedzicząca po MenuItem, która tworzy okno dialogowe typu Alert z informacjami o obsłudze programu
 * @brief Klasa Guide dziedzicząca po MenuItem, która tworzy okno dialogowe typu Alert z informacjami o obsłudze programu
 * */	
public class Guide extends MenuItem {
    public Guide(){
        super("Guide");
        initialize();
    }
/**
 * Metoda initialize() tworząca okno dialogowe typu Alert z informacjami o obsłudze programu
 * @fn private void initialize()
 * @brief Metoda initialize() tworząca okno dialogowe typu Alert z informacjami o obsłudze programu
 * */
    private void initialize(){
        setOnAction(e -> {
            // Tworzenie okienka dialogowego typu Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guide");
            alert.setHeaderText("Guide");
            alert.setContentText("- Create shapes by clicking buttons from the lower menu\n" +
                                 "- Hold the right mouse button to move the shape\n" +
                                 "- Scroll to change the size of the shape\n" +
                                 "- Scroll + Ctrl to rotate the shape (note that rotating circle has no effect \n" +
                                 "- Click the left mouse button to change the shape's colour\n");

            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    alert.close();
                }
            });
        });
    }
}
