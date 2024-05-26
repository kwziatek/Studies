/**
 * @file Main.java
 * @brief Klasa Main dziedzicząca po Application, która tworzy okno główne programu
 */
package app.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


import java.io.IOException;

public class Main extends Application {
	/**
	 * Metoda start(Stage stage) tworząca okno główne programu
	 * @fn public void start(Stage stage)
	 * @brief Metoda start(Stage stage) tworząca okno główne programu
	 * */
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane=new BorderPane();
        Scene scene= new Scene(borderPane,1000,500);
        Pane pane=new Pane();
        pane.setId("pane");
        borderPane.setCenter(pane);

        Label control= new Label();
        control.setId("control");
        control.setVisible(false);
        borderPane.setOnKeyPressed(e->{
            if(e.isControlDown()){
                control.setText("true");
            }
            else
                control.setText("false");
        });
        borderPane.setOnKeyReleased(e->{
            if(e.isControlDown()){
                control.setText("true");
            }
            else
                control.setText("false");
        });

        Label figure= new Label();
        figure.setVisible(false);

        Label message= new Label("Waiting for the first action");
        message.setId("message");
        figure.setVisible(true);

        MenuBar menuBar= new MenuBar();

        Menu info= new Menu("Info");
        Info information= new Info();
        Guide guide= new Guide();
        info.getItems().addAll(guide,information);



        Menu file= new Menu("File");
        Save save=new Save(scene);
        Load load=new Load(scene);
        file.getItems().addAll(load,save);
        menuBar.getMenus().addAll(info,file);

        HBox lowerMenu=new HBox(5);
        lowerMenu.setMinHeight(50);
        lowerMenu.setMaxHeight(50);
        lowerMenu.setAlignment(Pos.CENTER_LEFT);
        Button rectangleBtn= new Button("Rectangle");
        rectangleBtn.setMinWidth(150);
        Button triangleBtn= new Button("Triangle");
        triangleBtn.setMinWidth(150);
        Button circleBtn= new Button("Circle");
        circleBtn.setMinWidth(150);
        lowerMenu.getChildren().addAll(rectangleBtn,triangleBtn,circleBtn,message,control);


        borderPane.setTop(menuBar);
        borderPane.setCenter(pane);
        borderPane.setBottom(lowerMenu);

        rectangleBtn.setOnAction(e->{
            figure.setText("rect");
        });
        triangleBtn.setOnAction(e->{
            figure.setText("tria");
        });
        circleBtn.setOnAction(e->{
            figure.setText("circ");
        });

        pane.setOnMouseClicked(e->{

            if(figure.getText().equals("rect")){
                MyRectangle myRectangle=new MyRectangle(scene);
                myRectangle.setX(e.getX());
                myRectangle.setY(e.getY());
                pane.getChildren().add(myRectangle);

            }
            else if(figure.getText().equals("tria")) {
                MyTriangle myTriangle = new MyTriangle(scene);
                myTriangle.getPoints().addAll(new Double[]{
                        e.getX(), e.getY(),
                        e.getX() + 70, e.getY() + 100,
                        e.getX() - 70, e.getY() + 100
                });
                pane.getChildren().add(myTriangle);
                message.setText("Triangle has been created");
            }
            else if(figure.getText().equals("circ")) {
                MyCircle myCircle= new MyCircle(scene);
                myCircle.setCenterX(e.getX());
                myCircle.setCenterY(e.getY());
                pane.getChildren().add(myCircle);
                message.setText("Circle has been created");
            }
            figure.setText("");
        });

        stage.setTitle("Graphic editor");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
