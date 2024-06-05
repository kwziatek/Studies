package app.version;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.ThreadLocalRandom;

public class Cell implements Runnable{
    private Rectangle rectangle;
    private final int x,y,k;
    private final double p;
    private Cell[][] cells;

    public Cell(int i, int j, int n, int m, int k, double p, Cell[][] cells, MyGridPane myGridPane){
        x=i;
        y=j;
        this.k=k;
        this.p=p;
        this.cells=cells;
        rectangle = new Rectangle(800.0/(double)n,572.0/(double)m, randomColor());
        myGridPane.add(rectangle,i,j);
    }
    @Override
    public void run() {
        while(true){
            double new_p = ThreadLocalRandom.current().nextDouble();
            if(new_p<=p){
                changeColor(randomColor());
            }
            else{
                changeColor(colorMean());
            }
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(k)+k/2);

            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private void changeColor(Color color){
        Platform.runLater(() -> rectangle.setFill(color));
    }
    private Color randomColor(){
        return Color.rgb(ThreadLocalRandom.current().nextInt(0,256),
        ThreadLocalRandom.current().nextInt(0,256),ThreadLocalRandom.current().nextInt(0,256));
    }
    private Color colorMean(){
        Color[] neighborColors = new Color[4];
        int[][] neighbors = {
                {(x+1)%cells.length,y}, {(x-1+cells.length)%cells.length,y},
                {x,(y+1)%cells[0].length}, {x, (y-1+cells[0].length)%cells[0].length}
        };
        for (int i = 0; i < 4; i++) {
            int nx = neighbors[i][0];
            int ny = neighbors[i][1];
            neighborColors[i] = (Color) cells[nx][ny].rectangle.getFill();
        }
        return colorAverage(neighborColors);
    }
    private Color colorAverage(Color[] colors){
        double total_red=0, total_blue=0, total_green=0;
        for(Color color: colors){
            total_red+=color.getRed();
            total_blue+=color.getBlue();
            total_green+=color.getGreen();
        }
        int l=colors.length;
        if(l==0){
            return Color.BLACK;
        }
        total_red/=l;
        total_green/=l;
        total_blue/=l;
        return new Color(total_red, total_green, total_blue, 1.0);
    }

}
