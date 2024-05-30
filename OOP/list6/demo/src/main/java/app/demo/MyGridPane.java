package app.demo;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MyGridPane extends GridPane {
    public MyGridPane(int n, int m, Stage stage, Scene scene){
        initialize(n,m,stage,scene);
    }
    public void initialize(int n, int m, Stage stage, Scene scene){
        BorderPane borderPane = (BorderPane) scene.lookup("#borderPane");
        double p=0.5,k=100.0;
        borderPane.setCenter(this);
        Rectangle[][] rectangle = new Rectangle[n][m];  //tablica zupelnie nie jest potrzebna
        Color[] colors = {Color.RED,Color.BEIGE,Color.GRAY};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                rectangle[i][j]=new Rectangle();
                rectangle[i][j].setWidth(100);
                rectangle[i][j].setHeight(100);
                rectangle[i][j].setFill(colors[(i+j)%colors.length]);
                this.add(rectangle[i][j],i,j);
            }
        }
        stage.sizeToScene(); /// nie dziala

    }
}
