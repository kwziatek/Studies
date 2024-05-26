package app.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MyButton extends Button {
    public MyButton(){
        this.setText("Click");
    }
    public void Mybuttonmethod(MyVBox myVBox, Stage stage){
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                myVBox.outputClear();
                String string= myVBox.getInput();
                String[] parts = string.split("\\s+");


                int row,column;
                try{
                    row=Integer.parseInt(parts[0]);
                    if(row<0){
                        myVBox.setOutput("Podaj nieujemna liczbe");
                        return;
                    }
                    if(row>32 ){
                        myVBox.setOutput("Podaj mniejsza liczbe");
                        return;
                    }
                    // Konwertujemy każdą część na typ int i zapisujemy w tablicy numbers
                    for (int i = 1; i < parts.length; i++) {
                        try {

                            myVBox.setOutput(Generator.generator(row,parts[i]));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }


                }
                catch (NumberFormatException e){
                    myVBox.setOutput("Zly typ danych");
                    return;
                }




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
