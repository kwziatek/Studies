package app.edytor_graficzny;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class MyTriangle extends Polygon {
    private double startX, startY, midX, midY;
    private Boolean displayed=false;
    public MyTriangle(Scene scene, Pane pane){
        initialize(scene,pane);
    }
    public void initialize(Scene scene,Pane pane){
        if(displayed)
            return;
        scene.setOnMouseClicked(event -> {
            startX = event.getX();
            startY = event.getY();
            System.out.println("Initialize");
            handleMouseClic(pane, scene, startX, startY);
        });
    }
    private void handleMouseClic(Pane pane, Scene scene, double startX, double startY){

        scene.setOnMouseClicked(event ->{
            midX = event.getX();
            midY = event.getY();
            System.out.println("Nested1");
            nestedMouseClic(pane, scene, startX, startY, midX, midY);
        });
    }
    private void nestedMouseClic(Pane pane, Scene scene, double startX, double startY, double midX, double midY){
        scene.setOnMouseClicked(event ->{
            if(displayed){
                displayed=false;
                initialize(scene,pane);
                return;
            }
            double lastX = event.getX();
            double lastY = event.getY();
            System.out.println("Nested2");
            drawTriangle(scene, pane, startX, startY, midX, midY, lastX, lastY);


        });
    }
    private void drawTriangle(Scene scene, Pane pane, double startX, double startY, double midX, double midY, double endX, double endY) {
        // Usuń poprzedni prostokąt, jeśli istnieje
        //pane.getChildren().removeIf(node -> node instanceof Rectangle);

        // Utwórz nowy prostokąt
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(startX,startY,
                                    midX,midY,
                                    endX,endY);
        triangle.setFill(Color.BLUE);
        //triangle.setStroke(Color.BLACK);


        // Dodaj prostokąt do panelu
        pane.getChildren().add(triangle);
        displayed=true;
        System.out.println("drawTri");
    }
}
