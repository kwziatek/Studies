package app.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class PascalApplication extends Application{
    public static void main(String [] args){
        Application.launch();
    }

    public void start(Stage stage) {
        MyVBox mybvox= new MyVBox();
        mybvox.MyVBoxmethod(stage);
        mybvox.setStyle("-fx-background-color: lightblue;");

        Scene scene=new Scene(mybvox);
        stage.setScene(scene);


        stage.getIcons().add(new Image("file:/C:\\Users\\wziat\\IdeaProjects\\lista5\\demo\\icon.png"));





        stage.show();
    }
}
