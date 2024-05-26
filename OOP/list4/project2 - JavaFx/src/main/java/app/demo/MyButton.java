package app.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MyButton extends Button {
    public MyButton(){
        this.setText("Click");
    }
    public void Mybuttonmethod(MyVBox myVBox, Stage stage){
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int n;
                try{
                    n= Integer.parseInt(myVBox.getInput());

                }
                catch (NumberFormatException e){
                    myVBox.setOutput("Zly typ danych");
                    return;
                }

                if(n<0){
                    myVBox.setOutput("Podaj nieujemna liczbe");
                    return;
                }
                if(n>32){
                    myVBox.setOutput("Podaj mniejsza liczbe");
                    return;
                }

                myVBox.setOutput(Generator.generator(n));
                stage.sizeToScene();

                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                double centerX = screenBounds.getMinX() + (screenBounds.getWidth() - stage.getWidth()) / 2;
                double centerY = screenBounds.getMinY() + (screenBounds.getHeight() - stage.getHeight()) / 2;

                // Set the position of the stage to center it on the screen
                stage.setX(centerX);
                stage.setY(centerY);
            }
        });
    }

}
