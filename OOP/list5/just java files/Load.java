/**
 * @file Load.java
 * @brief Klasa Load dziedzicząca po MenuItem, która tworzy okno dialogowe typu FileChooser do wczytywania plików
 */
	
package app.demo1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.swing.text.html.MinimalHTMLWriter;
import java.io.File;
import java.util.Scanner;
/**
 * Klasa Load dziedzicząca po MenuItem, która tworzy okno dialogowe typu FileChooser do wczytywania plików
 * @class Load
 * @details Klasa Load dziedzicząca po MenuItem, która tworzy okno dialogowe typu FileChooser do wczytywania plików
 * @brief Klasa Load dziedzicząca po MenuItem, która tworzy okno dialogowe typu FileChooser do wczytywania plików
 * */
public class Load extends MenuItem {
    public Load(Scene scene){
        super("Load");
        initialize(scene);
    }
	/**
	 * Metoda initialize(Scene scene) tworząca okno dialogowe typu FileChooser do wczytywania plików
	 * @fn private void initialize(Scene scene)
	 * @brief Metoda initialize(Scene scene) tworząca okno dialogowe typu FileChooser do wczytywania plików
	 * */

    private void initialize(Scene scene){
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
			/**
			 * Metoda handle(ActionEvent actionEvent) obsługująca wczytywanie plików
			 * @fn public void handle(ActionEvent actionEvent)
			 * @brief Metoda handle(ActionEvent actionEvent) obsługująca wczytywanie plików
			 * */

            public void handle(ActionEvent actionEvent) {
				
                Pane pane=(Pane) scene.lookup("#pane");
                Label message=(Label) scene.lookup("#message");
                try{
                    while(pane.getChildren().get(0)!=null)
                        pane.getChildren().remove(pane.getChildren().get(0));
                }catch(Exception e){
                }
                FileChooser fileChooser=new FileChooser();
                File file=fileChooser.showOpenDialog(null);
                try{
                    Scanner scanner=new Scanner(file);
                    String line=scanner.nextLine();

                    while(line!=null){
                        if(line.equals("rect")){
                            MyRectangle myRectangle=new MyRectangle(scene);
                            myRectangle.setX(Double.parseDouble(scanner.nextLine()));
                            myRectangle.setY(Double.parseDouble(scanner.nextLine()));

                            myRectangle.setFill(Color.web(scanner.nextLine()));
                            myRectangle.setScaleX(Double.parseDouble(scanner.nextLine()));
                            myRectangle.setScaleY(Double.parseDouble(scanner.nextLine()));
                            myRectangle.setRotate(Double.parseDouble(scanner.nextLine()));
                            pane.getChildren().add(myRectangle);
                        }
                        else if(line.equals("tria")){
                            MyTriangle myTriangle=new MyTriangle(scene);
                            myTriangle.getPoints().addAll(new Double[]{
                                Double.parseDouble(scanner.nextLine()),Double.parseDouble(scanner.nextLine()),
                                Double.parseDouble(scanner.nextLine()),Double.parseDouble(scanner.nextLine()),
                                Double.parseDouble(scanner.nextLine()),Double.parseDouble(scanner.nextLine())
                            });
                            myTriangle.setFill(Color.web(scanner.nextLine()));
                            myTriangle.setScaleX(Double.parseDouble(scanner.nextLine()));
                            myTriangle.setScaleY(Double.parseDouble(scanner.nextLine()));
                            myTriangle.setRotate(Double.parseDouble(scanner.nextLine()));
                            pane.getChildren().add(myTriangle);
                        }
                        else if(line.equals("circ")){
                                MyCircle myCircle=new MyCircle(scene);
                                myCircle.setCenterX(Double.parseDouble(scanner.nextLine()));
                                myCircle.setCenterY(Double.parseDouble(scanner.nextLine()));

                                myCircle.setFill(Color.web(scanner.nextLine()));
                                myCircle.setScaleX(Double.parseDouble(scanner.nextLine()));
                                myCircle.setScaleY(Double.parseDouble(scanner.nextLine()));
                                myCircle.setRotate(Double.parseDouble(scanner.nextLine()));
                                pane.getChildren().add(myCircle);
                        }
                        line=scanner.nextLine();

                    }
                    scanner.close();
                    message.setText("File has been loaded");

                }
                catch (Exception e){

                }



            message.setText("File has been loaded");
            }
        });
    }

}
