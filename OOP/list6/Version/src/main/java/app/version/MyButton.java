package app.version;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class MyButton extends Button {

    public MyButton(String s){
        super(s);
    }
    public void initialize(BorderPane borderPane, TextField textField, Label label){
        this.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String s = textField.getText();
                String[] words = s.split("\\s+");

                if (words.length > 3 && (!words[0].isEmpty() || words.length > 4)) {
                    if (words[0].isEmpty()) {
                        words[0] = words[1];
                        words[1] = words[2];
                    }
                    try {
                        int n = Integer.parseInt(words[0]);
                        int m = Integer.parseInt(words[1]);
                        double p = Double.parseDouble(words[2]);
                        int k = Integer.parseInt(words[3]);
                        if (n < 1 || m < 1 || k < 1) {
                            label.setText("Podano niedodatnie argument(y)");
                        } else if (p < -1 || p > 1) {
                            label.setText("Podano nieprawidłowe p");
                        } else {
                            MyGridPane myGridPane = new MyGridPane(n, m, k, p);
                            myGridPane.initialize();
                            borderPane.setCenter(myGridPane);
                            label.setText("");
                        }
                    } catch (NumberFormatException e1) {
                        label.setText("Przynajmniej jeden z argumentów nie jest liczbą całkowitą dodatnią");
                        //e1.getStackTrace();
                    }
                } else {
                    label.setText("Podano za mało argumentów");
                }

            }

        });
    }


}
