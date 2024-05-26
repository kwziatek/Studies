/**
 * @file MyTriangle.java
 * @brief Klasa MyTriangle dziedzicząca po Polygon, która tworzy trójkąt
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
import javafx.scene.shape.Polygon;
/**
 * Klasa MyTriangle dziedzicząca po Polygon, która tworzy trójkąt
 * @class MyTriangle
 * @details Klasa MyTriangle dziedzicząca po Polygon, która tworzy trójkąt
 * @brief Klasa MyTriangle dziedzicząca po Polygon, która tworzy trójkąt
 * */
public class MyTriangle extends Polygon {
    public MyTriangle(Scene scene){
        super();
        Label message=(Label) scene.lookup("#message");
        message.setText("Triangle has been created");
        initialize(scene);
    }
	/**
	 * Metoda initialize(Scene scene) inicjalizująca trójkąt
	 * @fn private void initialize(Scene scene)
	 * @brief Metoda initialize(Scene scene) inicjalizująca trójkąt
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

                    message.setText("The colour of a triangle has been changed");
                }

            }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton()==MouseButton.SECONDARY){
                    getPoints().set(0, mouseEvent.getX());
                    getPoints().set(1, mouseEvent.getY()-50);
                    getPoints().set(2, mouseEvent.getX()-70);
                    getPoints().set(3, mouseEvent.getY()+50);
                    getPoints().set(4, mouseEvent.getX()+70);
                    getPoints().set(5, mouseEvent.getY()+50);
                }
                message.setText("A triangle has been moved");
            }

        });
        setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                if(control.getText().equals("true")){
                    setRotate(getRotate()+scrollEvent.getDeltaY());
                    message.setText("A triangle has been rotated");
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
                    message.setText("The size of a triangle has been changed");
                }
            }
        });
    }
}
