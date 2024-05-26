/**
 * @file Save.java
 * @brief Klasa Save dziedzicząca po MenuItem, która zapisuje rysunek do pliku
 */
package app.demo1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 * Klasa Save dziedzicząca po MenuItem, która zapisuje rysunek do pliku
 * @class Save
 * @details Klasa Save dziedzicząca po MenuItem, która zapisuje rysunek do pliku
 * @brief Klasa Save dziedzicząca po MenuItem, która zapisuje rysunek do pliku
 * */
public class Save extends MenuItem {
    public Save(Scene scene){
        super("Save");
        initialize(scene);
    }
	/**
	 * Metoda initialize(Scene scene) zapisująca rysunek do pliku
	 * @fn private void initialize(Scene scene)
	 * @brief Metoda initialize(Scene scene) zapisująca rysunek do pliku
	 * */
    private void initialize(Scene scene){

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Label message=(Label) scene.lookup("#message");
                try{

                    int i=0;
                    File file=new File("Drawing"+i+".txt");
                    while(file.exists()){
                        i++;
                        file=new File("Drawing"+i+".txt");
                    }
                    if(file.createNewFile()){

                    }
                    else
                        throw new Exception("Nie udało się stworzyć pliku");

                    PrintWriter printWriter=new PrintWriter("Drawing"+i+".txt");

                    Pane pane=(Pane) scene.lookup("#pane");
                    for(int j=0; pane.getChildren().get(j)!=null; j++){
                        if(pane.getChildren().get(j) instanceof MyRectangle){
                            MyRectangle myRectangle=(MyRectangle) pane.getChildren().get(j);
                            printWriter.write("rect\n");
                            printWriter.write(myRectangle.getX()+"\n");
                            printWriter.write(myRectangle.getY()+"\n");
                            printWriter.write(myRectangle.getFill()+"\n");
                            printWriter.write(myRectangle.getScaleX()+"\n");
                            printWriter.write(myRectangle.getScaleY()+"\n");
                            printWriter.write(myRectangle.getRotate()+"\n");
                        }
                        else if(pane.getChildren().get(j) instanceof MyCircle){
                            MyCircle myCircle=(MyCircle) pane.getChildren().get(j);
                            printWriter.write("circ\n");
                            printWriter.write(myCircle.getCenterX()+"\n");
                            printWriter.write(myCircle.getCenterY()+"\n");
                            printWriter.write(myCircle.getFill()+"\n");
                            printWriter.write(myCircle.getScaleX()+"\n");
                            printWriter.write(myCircle.getScaleY()+"\n");
                            printWriter.write(myCircle.getRotate()+"\n");
                        }
                        else if(pane.getChildren().get(j) instanceof MyTriangle){
                            MyTriangle myTriangle=(MyTriangle) pane.getChildren().get(j);
                            printWriter.write("tria\n");
                            printWriter.write(myTriangle.getPoints().get(0)+"\n");
                            printWriter.write(myTriangle.getPoints().get(1)+"\n");
                            printWriter.write(myTriangle.getPoints().get(2)+"\n");
                            printWriter.write(myTriangle.getPoints().get(3)+"\n");
                            printWriter.write(myTriangle.getPoints().get(4)+"\n");
                            printWriter.write(myTriangle.getPoints().get(5)+"\n");
                            printWriter.write(myTriangle.getFill()+"\n");
                            printWriter.write(myTriangle.getScaleX()+"\n");
                            printWriter.write(myTriangle.getScaleY()+"\n");
                            printWriter.write(myTriangle.getRotate()+"\n");
                        }
                        printWriter.flush();
                    }

                }
                catch (Exception e){

                }
            message.setText("File has been saved");
            }
        });

    }
}
