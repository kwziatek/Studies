/**
 * @file MyCircle.java
 * @brief Klasa MyCircle dziedzicząca po Circle, która tworzy okrąg, który można przesuwać, zmieniać jego rozmiar i kolor
 */
package app.demo1;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;

import java.awt.*;
/**
 * Klasa MyRectangle dziedzicząca po Rectangle, która tworzy prostokąt, który można przesuwać, zmieniać jego rozmiar i kolor
 * @class MyRectangle
 * @details Klasa MyRectangle dziedzicząca po Rectangle, która tworzy prostokąt, który można przesuwać, zmieniać jego rozmiar i kolor
 * @brief Klasa MyRectangle dziedzicząca po Rectangle, która tworzy prostokąt, który można przesuwać, zmieniać jego rozmiar i kolor
 * */
public class MyRectangle extends Rectangle {

    MyRectangle(Scene scene){
        super(200,150);
        Label message=(Label) scene.lookup("#message");
        message.setText("Rectangle has been created");
        initialize(scene);
    }
	/**
	 * Metoda initialize(Scene scene) inicjalizująca prostokąt
	 * @fn private void initialize(Scene scene)
	 * @brief Metoda initialize(Scene scene) inicjalizująca prostokąt
	 * */
    private void initialize(Scene scene){
        Pane pane=(Pane) scene.lookup("#pane") ;
        Label control=(Label) scene.lookup("#control");
        Label message=(Label) scene.lookup("#message");

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton()== MouseButton.PRIMARY){
                    ColorPicker colorPicker=new ColorPicker((Color)getFill());
                    colorPicker.setVisible(true);
                    pane.getChildren().add(colorPicker);
                    colorPicker.relocate(mouseEvent.getX(),mouseEvent.getY());
                    colorPicker.show();
                    colorPicker.setOnAction(e->{
                        setFill(colorPicker.getValue());
                        pane.getChildren().remove(colorPicker);
                    });
                    message.setText("The colour of a rectangle has been changed");
                }
            }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton()== MouseButton.SECONDARY) {
                    setX(mouseEvent.getX() - getWidth() / 2);
                    setY(mouseEvent.getY() - getHeight() / 2);
                    message.setText("A rectangle has been moved");
                }
            }
        });
        setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                if(control.getText().equals("true")){
                    setRotate(getRotate()+scrollEvent.getDeltaY());
                    message.setText("A rectangle has been rotated");
                }
                else{
                    if(scrollEvent.getDeltaY()>0){
                        setScaleX(getScaleX()*1.1);
                        setScaleY(getScaleY()*1.1);
                    }
                    else{
                        setScaleX(getScaleX()*0.9);
                        setScaleY(getScaleY()*0.9);
                    }
                    message.setText("The size of a rectangle has been changed");
                }
            }
        });
    }


}
