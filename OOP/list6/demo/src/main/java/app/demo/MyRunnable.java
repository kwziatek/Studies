package app.demo;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

public class MyRunnable implements Runnable {
    private final Rectangle rectangle;
    int k;
    double p;
    private volatile boolean running = true;

    public MyRunnable(Rectangle rectangle, int k, double p) {
        this.rectangle = rectangle;
        this.k=k;
        this.p=p;
    }

    @Override
    public void run() {
        while (running) {
            //if (!running) break;
            double new_p = ThreadLocalRandom.current().nextDouble(0,1);
            if(new_p>=p){
                int red = ThreadLocalRandom.current().nextInt(0, 256);
                int green = ThreadLocalRandom.current().nextInt(0, 256);
                int blue = ThreadLocalRandom.current().nextInt(0, 256);
                Color newColor = Color.rgb(red, green, blue);
                Platform.runLater(() -> rectangle.setFill(newColor));
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
}