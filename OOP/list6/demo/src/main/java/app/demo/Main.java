package app.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pane pane= new Pane();
        BorderPane borderPane= new BorderPane();
        borderPane.setId("borderPane");
        borderPane.setTop(pane);

        Button button=new Button("Stwórz symulację");
        button.layoutXProperty().bind(pane.widthProperty().subtract(button.widthProperty()).divide(2));
        button.layoutYProperty().bind(pane.heightProperty().subtract(button.heightProperty()).divide(2));

        TextField textField=new TextField("");
        textField.layoutXProperty().bind(button.layoutXProperty().subtract(textField.widthProperty()));
//        textField.layoutYProperty().bind(button.layoutYProperty().subtract(textField.heightProperty()));

        Label label=new Label("");
        label.setFont(new Font("Arial",20));
        label.setTextFill(Color.RED);
        label.layoutXProperty().bind(button.layoutXProperty().add(button.widthProperty()));
        pane.getChildren().addAll(button,textField,label);
        Scene scene=new Scene(borderPane,500,300);
        stage.setScene(scene);
        stage.show();




        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String s=textField.getText();
                String[] words = s.split("\\s+");

                if(words.length>1 && (words[0]!="" || words.length>2)){
                    if(words[0]==""){
                        words[0]=words[1];
                        words[1]=words[2];
                    }
//                        System.out.println(words[0]);
//                        System.out.println(words[1]);
                    try{
                        int n=Integer.parseInt(words[0]);
                        int m=Integer.parseInt(words[1]);
                        if(n<1 || m<1){
                            label.setText("Podano niedodatnie argument(y)");
                        }
                        else{
                            MyGridPane  myGridPane = new MyGridPane(Integer.parseInt(words[0]),Integer.parseInt(words[1]),stage,scene);
                        }
                    }
                    catch (NumberFormatException e1){
                        label.setText("Przynajmniej jeden z argumentów nie jest liczbą całkowitą dodatnią");
                        //e1.getStackTrace();
                    }
                }
                else{
                    label.setText("Podano za mało argumentów");
                }

                stage.sizeToScene(); // nie dziala
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}