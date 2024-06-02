package app.demo;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

public class MyRunnable implements Runnable {
    public Rectangle rectangle;
    int k;
    int x,y;
    double p;
    private volatile boolean running = true;
    MyGridPane myGridPane;

    public MyRunnable(Rectangle rectangle, int x, int y, int k, double p, MyGridPane myGridPane) {
        this.rectangle = rectangle;
        this.k=k;
        this.p=p;
        this.myGridPane = myGridPane;

    }

    @Override
    public void run() {
        while (running) {
            //if (!running) break;
            double new_p = ThreadLocalRandom.current().nextDouble(0,1);
            if(new_p<=p){
                Color newColor = randomColor();
                rectangle.setFill(newColor);
            }
            else{
                    colorUpdate(rectangle,x,y);
            }

            try {
                int wait=ThreadLocalRandom.current().nextInt(k/2,3*k/2+1);
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                running = false;
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        running = false;
    }
    public void colorUpdate(Rectangle rectangle, int  i, int j){
        Color newColor = myGridPane.colorMean(i,j);
        rectangle.setFill(newColor);
        Platform.runLater(() -> rectangle.setFill(newColor));
    }
    public static Color randomColor(){
        int red = ThreadLocalRandom.current().nextInt(0, 256);
        int green = ThreadLocalRandom.current().nextInt(0, 256);
        int blue = ThreadLocalRandom.current().nextInt(0, 256);
        return Color.rgb(red, green, blue);
    }
}