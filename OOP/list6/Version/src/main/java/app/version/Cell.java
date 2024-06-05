package app.version;

import javafx.application.Platform;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.ThreadLocalRandom;

public class Cell implements Runnable {
    private final Rectangle rectangle;
    private final int x, y, k;
    private final double p;
    private final Cell[][] cells;
    private boolean suspended = false;
    private final Thread thread = new Thread();

    public Cell(int i, int j, int n, int m, int k, double p, Cell[][] cells, MyGridPane myGridPane) {
        x = i;
        y = j;
        this.k = k;
        this.p = p;
        this.cells = cells;
        rectangle = new Rectangle(800.0 / (double) n, 572.0 / (double) m, randomColor());
        myGridPane.add(rectangle, i, j);

        // Add click event handler to toggle suspension state
        rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> toggleSuspend());
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (thread) {
                    while (suspended) {
                        thread.wait();
                    }
                }

                double new_p = ThreadLocalRandom.current().nextDouble();
                if (new_p <= p) {
                    changeColor(randomColor());
                } else {
                    changeColor(colorMean());
                }
                Thread.sleep(ThreadLocalRandom.current().nextInt(k) + k / 2);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }

    private void changeColor(Color color) {
        Platform.runLater(() -> rectangle.setFill(color));
    }

    private Color randomColor() {
        return Color.rgb(ThreadLocalRandom.current().nextInt(0, 256),
                ThreadLocalRandom.current().nextInt(0, 256), ThreadLocalRandom.current().nextInt(0, 256));
    }

    private Color colorMean() {
        Color[] neighborColors = new Color[4];
        int[][] neighbors = {
                {(x + 1) % cells.length, y}, {(x - 1 + cells.length) % cells.length, y},
                {x, (y + 1) % cells[0].length}, {x, (y - 1 + cells[0].length) % cells[0].length}
        };
        for (int i = 0; i < 4; i++) {
            int nx = neighbors[i][0];
            int ny = neighbors[i][1];
            if(!cells[nx][ny].isSuspended())
            neighborColors[i] = (Color) cells[nx][ny].rectangle.getFill();
        }
        return colorAverage(neighborColors);
    }

    private Color colorAverage(Color[] colors) {
        double totalRed = 0, totalBlue = 0, totalGreen = 0;
        int l = 0;
        for (Color color : colors) {
            if(color!=null){
                totalRed += color.getRed();
                totalBlue += color.getBlue();
                totalGreen += color.getGreen();
                l++;
            }
        }
        if (l == 0) {
            return Color.BLACK;
        }
        totalRed /= l;
        totalGreen /= l;
        totalBlue /= l;
        return new Color(totalRed, totalGreen, totalBlue, 1.0);
    }

    private void toggleSuspend() {
        synchronized (thread) {
            suspended = !suspended;
            if (!suspended) {
                thread.notify();
            }
        }
    }
    public boolean isSuspended() {
        return suspended;
    }
}
