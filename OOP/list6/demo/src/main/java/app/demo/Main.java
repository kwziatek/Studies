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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private MyGridPane myGridPane;
    @Override
    public void start(Stage stage) throws IOException {

        HBox hBox= new HBox();
        BorderPane borderPane= new BorderPane();
        borderPane.setId("borderPane");
        borderPane.setTop(hBox);

        Button button=new Button("Stwórz symulację");
//        button.layoutXProperty().bind(hBox.widthProperty().subtract(button.widthProperty()).divide(2));
//        button.layoutYProperty().bind(hBox.heightProperty().subtract(button.heightProperty()).divide(2));

        TextField textField=new TextField("");
//        textField.layoutXProperty().bind(button.layoutXProperty().subtract(textField.widthProperty()));
//        textField.layoutYProperty().bind(button.layoutYProperty().subtract(textField.heightProperty()));

        Label label=new Label("");
        label.setFont(new Font("Arial",20));
        label.setTextFill(Color.RED);
//        label.layoutXProperty().bind(button.layoutXProperty().add(button.widthProperty()));
        hBox.getChildren().addAll(button,textField,label);
        Scene scene=new Scene(borderPane,1000,800);
        stage.setScene(scene);
        stage.show();




        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String s=textField.getText();
                String[] words = s.split("\\s+");

                if(words.length>3 && (words[0]!="" || words.length>4)){
                    if(words[0]==""){
                        words[0]=words[1];
                        words[1]=words[2];
                    }
//                        System.out.println(words[0]);
//                        System.out.println(words[1]);
                    try{
                        int n=Integer.parseInt(words[0]);
                        int m=Integer.parseInt(words[1]);
                        double p = Double.parseDouble(words[2]);
                        int k = Integer.parseInt(words[3]);
                        if(n<1 || m<1 || k<1){
                            label.setText("Podano niedodatnie argument(y)");
                        }
                        else if(p<-1 || p>1){
                            label.setText("Podano nieprawidłowe p");
                        }
                        else{

                            if (myGridPane != null) {
                                myGridPane.stopThreads();
                            }
                            MyGridPane  myGridPane = new MyGridPane(n,m,k,p,scene);
                            borderPane.setCenter(myGridPane);

                            myGridPane.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
                                stage.sizeToScene();
                            });
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

        stage.setOnCloseRequest(event -> {
            if (myGridPane != null) {
                myGridPane.stopThreads();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}