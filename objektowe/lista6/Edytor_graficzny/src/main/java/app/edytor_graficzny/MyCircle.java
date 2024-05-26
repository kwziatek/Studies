package app.edytor_graficzny;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class MyCircle extends Circle{
    private double startX;
    private double startY;

    public MyCircle(Scene scene, Pane pane){
        initialize(scene,pane);
    }
    public void initialize(Scene scene, Pane pane){
        pane.setOnMousePressed(event -> {
            startX = event.getX();
            startY = event.getY();
        });
        pane.setOnMouseReleased(event -> {
            double endX = event.getX();
            double endY = event.getY();
            drawCircle(pane, startX, startY, endX, endY);
        });
    }
    private void drawCircle(Pane pane, double startX, double startY, double endX, double endY) {
        // Usuń poprzedni prostokąt, jeśli istnieje
        //pane.getChildren().removeIf(node -> node instanceof Rectangle);

        // Utwórz nowy prostokąt
        Circle circle = new Circle();
        circle.setCenterX(startX);
        circle.setCenterY(startY);
        circle.setRadius(Math.sqrt((endX-startX)*(endX-startX)+(endY-startY)*(endY-startY)));
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.BLACK);


        // Dodaj prostokąt do panelu
        pane.getChildren().add(circle);
    }
}
