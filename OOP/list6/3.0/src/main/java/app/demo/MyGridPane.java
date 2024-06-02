package app.demo;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MyGridPane extends GridPane {
    private MyRunnable[][] runnables;
    private Thread[][] threads;
    public MyGridPane(int n, int m, int k, double p, Scene scene){
        initialize(n,m,k,p,scene);
        setWidth(50*n);
        setHeight(50*m);
    }
    public void initialize(int n, int m, int k, double p, Scene scene){
        BorderPane borderPane = (BorderPane) scene.lookup("#borderPane");
        runnables = new MyRunnable[n][m];
        threads = new Thread[n][m];
        Color[] colors = {Color.RED,Color.BEIGE,Color.GRAY};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Rectangle rectangle = new Rectangle(50, 50);
                MyRunnable runnable = new MyRunnable(rectangle,k,p);
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
}
