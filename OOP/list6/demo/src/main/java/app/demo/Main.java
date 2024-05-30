package app.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pane pane= new Pane();
        BorderPane borderPane= new BorderPane();
        borderPane.setTop(pane);

        Button button=new Button("Stwórz symulację");
        button.layoutXProperty().bind(pane.widthProperty().subtract(button.widthProperty()).divide(2));
        button.layoutYProperty().bind(pane.heightProperty().subtract(button.heightProperty()).divide(2));
        TextField textField=new TextField("");
        pane.getChildren().addAll(button,textField);
        Scene scene=new Scene(borderPane,400,300);
        stage.setScene(scene);
        stage.show();

//        textField.layoutXProperty().bind(pane.widthProperty().subtract(button.widthProperty()).divide(2));
//        textField.layoutYProperty().bind(pane.heightProperty().subtract(button.heightProperty()).divide(2));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String s=textField.getText();
                String[] words = s.split("\\s+");
                try{
                    int n=Integer.parseInt(words[0]);
                    int m=Integer.parseInt(words[1]);
                }
                catch{
                    textField.setText("Podano złe parametry");

                }
                int n=Integer.parseInt(words[0]);
                int m=Integer.parseInt(words[1]);

                if(n<1 || m<1){
                    textField.setText("Podano ujemne argument(y)");
                }
                else{
                    MyGridPane  myGridPane = new MyGridPane(Integer.parseInt(words[0]),Integer.parseInt(words[1]),scene);
                }


            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}