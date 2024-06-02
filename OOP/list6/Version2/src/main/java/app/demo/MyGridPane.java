package app.demo;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

public class MyGridPane extends GridPane {
    private MyRunnable[][] runnables;
    private Thread[][] threads;
    int n,m,k;
    double p;
    public MyGridPane(int n, int m, int k, double p, Scene scene){

        setWidth(50*n);
        setHeight(50*m);
        this.n=n;
        this.m=m;
        this.k=k;
        this.p=p;
        System.out.println("rwre");
        initialize(scene);
    }
    public void initialize(Scene scene){
        BorderPane borderPane = (BorderPane) scene.lookup("#borderPane");
        runnables = new MyRunnable[n][m];
        threads = new Thread[n][m];
        Color[] colors = {Color.RED,Color.BEIGE,Color.GRAY};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.println(i+" "+j);
                Rectangle rectangle = new Rectangle(50, 50,Color.GREEN);
                rectangle.setFill(MyRunnable.randomColor());
                MyRunnable runnable = new MyRunnable(rectangle,i,j,k,p,this);
                runnables[i][j] = runnable;
                Thread thread = new Thread(runnables[i][j]);
                thread.setDaemon(true);
                threads[i][j] = thread;
                threads[i][j].start();
                this.add(rectangle,i,j);
            }
        }
        setGridLinesVisible(true);

        // Set preferred size based on rows and cols
        setPrefSize(n * 50, m * 50);
    }
    public void stopThreads() {
        for (int i = 0; i < runnables.length; i++) {
            for (int j = 0; j < runnables[i].length; j++) {
                if (runnables[i][j] != null) {
                    runnables[i][j].stop();
                }
            }
        }

        for (int i = 0; i < threads.length; i++) {
            for (int j = 0; j < threads[i].length; j++) {
                if (threads[i][j] != null) {
                    try {
                        threads[i][j].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public Color colorMean(int i, int j){
        double total_red = 0;
        double total_blue = 0;
        double total_green = 0;
        int count = 0;

        if(i < n-1 && runnables[i+1][j] != null){
            Color color = (Color) runnables[i+1][j].rectangle.getFill();
            total_red += color.getRed();
            total_green += color.getGreen();
            total_blue += color.getBlue();
            count++;
        }
        if(i > 0 && runnables[i-1][j] != null){
            Color color = (Color) runnables[i-1][j].rectangle.getFill();
            total_red += color.getRed();
            total_green += color.getGreen();
            total_blue += color.getBlue();
            count++;
        }
        if(j < m-1 && runnables[i][j+1] != null){
            Color color = (Color) runnables[i][j+1].rectangle.getFill();
            total_red += color.getRed();
            total_green += color.getGreen();
            total_blue += color.getBlue();
            count++;
        }
        if(j > 0 && runnables[i][j-1] != null){
            Color color = (Color) runnables[i][j-1].rectangle.getFill();
            total_red += color.getRed();
            total_green += color.getGreen();
            total_blue += color.getBlue();
            count++;
        }

        if(count == 0) {
            return Color.BLACK; // or any default color
        }

        double average_red = total_red / count;
        double average_green = total_green / count;
        double average_blue = total_blue / count;

        return new Color(average_red, average_green, average_blue, 1.0); // Assuming full opacity
    }

}
