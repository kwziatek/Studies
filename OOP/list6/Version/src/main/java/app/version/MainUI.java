package app.version;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainUI {

    public MainUI(Stage stage){
        BorderPane borderPane= new BorderPane();
        Scene scene=new Scene(borderPane,800,600);

        HBox hBox= new HBox();
        borderPane.setTop(hBox);
        Label label=new Label("");
        label.setFont(new Font("Arial",20));
        label.setTextFill(Color.RED);
        TextField textField=new TextField("");
        MyButton myButton = new MyButton("Stwórz symulację");
        myButton.initialize(borderPane,textField,label);
        hBox.getChildren().addAll(myButton,textField,label);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
