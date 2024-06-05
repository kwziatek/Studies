package app.version;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MyGridPane extends GridPane {
    private final int n,m,k;
    private final double p;

    public MyGridPane(int n, int m, int k , double p){
        this.n=n;
        this.m=m;
        this.k=k;
        this.p=p;
    }

    public void initialize(){
        setGridLinesVisible(true);
        Cell[][] cells = new Cell[n][m];
        Thread[][] threads = new Thread[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cells[i][j] = new Cell(i, j, n, m, k, p, cells, this);
                threads[i][j] = new Thread(cells[i][j]);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                threads[i][j].start();
            }
        }
    }
}
