package app.inna_wersja;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.input.*;

public class Rectang extends Rectangle{
    Rectang(Scene scene){
        super(100,50);
        Pane canvas = (Pane) scene.lookup("#canvas");
        Label mousePos = (Label) scene.lookup("#mousePos");
        Label control = (Label) scene.getRoot().lookup("#control");
        Label number = (Label) scene.getRoot().lookup("#number1");
        ColorPicker colorPicker = (ColorPicker) scene.lookup("#colorPicker");
        /**
         * setOnMouseClicked is a method that sets the action of the right mouse button click to change the color of the shape
         */
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
             * Method that sets the action of the right mouse button click to change the color of the shape
             * @param event
             * @throws Exception
             */
            public void handle(MouseEvent event) {
                try{
                    if(event.getButton() == MouseButton.SECONDARY){
                        colorPicker.relocate(event.getX(), event.getY()-colorPicker.getHeight());
                        colorPicker.show();
                        colorPicker.setOnAction(e->{
                            setFill(colorPicker.getValue());
                        });
                    }
                }catch(Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        });
        /**
         * setOnMouseDragged is a method that sets the action of the mouse drag to move the shape
         */
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try{
                    if(event.getSceneX()<=canvas.getWidth() && event.getSceneY()<=canvas.getHeight()){
                        mousePos.setText("Mouse position: " + event.getSceneX() + ", " + event.getSceneY());
                    }else{
                        mousePos.setText("Mouse out of canvas");
                    }

                    setX(getWidth()/-2+event.getX());
                    setY(getHeight()/-2+event.getY());
                }catch(Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        });
        /**
         * setOnScroll is a method that sets the action of the mouse scroll to rotate or scale the shape
         */
        setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                try{
                    if(control.getText().equals("true")){
                        setRotate(getRotate()+event.getDeltaY());
                    }else{
                        if(event.getDeltaY() > 0){
                            setScaleX(getScaleX()*1.15);
                            setScaleY(getScaleY()*1.15);
                        }else{
                            setScaleX(getScaleX()*0.95);
                            setScaleY(getScaleY()*0.95);
                        }
                    }
                }catch(Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        });
    }

}