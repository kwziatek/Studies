/**
 * @file MyCircle.java
 * @brief Klasa MyCircle dziedzicząca po Circle, która tworzy okrąg
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
import javafx.scene.shape.Circle;
/**
 * Klasa MyCircle dziedzicząca po Circle, która tworzy okrąg
 * @class MyCircle
 * @details Klasa MyCircle dziedzicząca po Circle, która tworzy okrag
 * @brief Klasa MyCircle dziedzicząca po Circle, która tworzy okrag
 * */
public class MyCircle extends Circle {
    public MyCircle(Scene scene){
        super(100);
        Label message=(Label) scene.lookup("#message");
        message.setText("Circle has been created");
        initialize(scene);
    }
    private void initialize(Scene scene){
        Pane pane=(Pane) scene.lookup("#pane") ;
        Label control=(Label) pane.lookup("#control");
        Label message=(Label) pane.lookup("#message");

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
                    //message.setText("The colour of a circle has been changed");
                }

            }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton()== MouseButton.SECONDARY) {
                    setCenterX(mouseEvent.getX());
                    setCenterY(mouseEvent.getY());
                    //message.setText("A circle has been moved");
                }
            }
        });
        setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                    if(scrollEvent.getDeltaY()>0){
                        setScaleX(getScaleX()*1.1);
                        setScaleY(getScaleY()*1.1);
                    }
                    else{
                        setScaleX(getScaleX()*0.9);
                        setScaleY(getScaleY()*0.9);
                    }
                    //message.setText("The size of a circle has been changed");

            }
        });
    }
}
