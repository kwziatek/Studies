package app.edytor_graficzny;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MyRectangle extends Rectangle {
    private double startX,startY;
    public MyRectangle(Scene scene, Pane pane){
        initialize(scene,pane);
    }
    public void initialize(Scene scene, Pane pane){
        pane.setOnMousePressed(event -> {
            startX = event.getX();
            startY = event.getY();
        });
//        scene.setOnMouseDragged(event -> {
//            double endX = event.getX();
//            double endY = event.getY();
//            drawRectangle(pane, startX, startY, endX, endY);
//        });
        pane.setOnMouseReleased(event -> {
            double endX = event.getX();
            double endY = event.getY();
            drawRectangle(pane, startX, startY, endX, endY);
        });
    }
    private void drawRectangle(Pane pane, double startX, double startY, double endX, double endY) {
        // Usuń poprzedni prostokąt, jeśli istnieje
        //pane.getChildren().removeIf(node -> node instanceof Rectangle);

        // Utwórz nowy prostokąt
        Rectangle rectangle = new Rectangle();
        rectangle.setX(Math.min(startX, endX));
        rectangle.setY(Math.min(startY, endY));
        rectangle.setWidth(Math.abs(endX - startX));
        rectangle.setHeight(Math.abs(endY - startY));
        rectangle.setFill(Color.BLUE);
        rectangle.setStroke(Color.BLACK);


        // Dodaj prostokąt do panelu
        pane.getChildren().add(rectangle);
    }
}
