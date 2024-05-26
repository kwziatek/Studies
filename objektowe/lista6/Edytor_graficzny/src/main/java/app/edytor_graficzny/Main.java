package app.edytor_graficzny;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {


        Pane root=new Pane();
        BorderPane borderPane=new BorderPane();

        Scene scene=new Scene(borderPane, 600,600,Color.SKYBLUE);
        MenuBar menuBar=new MenuBar();


        Menu create=new Menu("Stwórz figurę");

        MenuItem prostokat=new MenuItem("Prostokąt");
        MenuItem trojkat=new MenuItem("Trójkąt");
        MenuItem okrag=new MenuItem("Okrąg");

        create.getItems().addAll(prostokat,trojkat,okrag);

        Menu activate =new Menu("Aktywuj figurę");

        Menu save=new Menu("Zapisz do pliku");

        Menu more=new Menu("Więcej");
        MenuItem info=new MenuItem("Info");
        MenuItem manual=new MenuItem("Instrukcja obsługi");

        more.getItems().addAll(info,manual);


        info.setOnAction(e -> {
            // Tworzenie okienka dialogowego typu Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Informacje");
            alert.setContentText("Nazwa programu: Edytor graficzny\nAutor: Karol Wziątek\nPrzeznaczenie: Projekt na ocenę z kursu programownia objektowego\nFunkcje: Rysowanie figur, zmienianie ich kolorów i wielkości, obracanie figur oraz zapisywanie dzieła do pliku");

            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    alert.close();
                }
            });
        });
        prostokat.setOnAction(e ->{
            MyRectangle myRectangle=new MyRectangle(scene,root);
            root.getChildren().add(myRectangle);
            prostokat.setOnAction(null);

        });
        okrag.setOnAction(e ->{
            MyCircle myCircle=new MyCircle(scene,root);
            root.getChildren().add(myCircle);

        });
        trojkat.setOnAction(e ->{
            MyTriangle myTriangle=new MyTriangle(scene,root);
            root.getChildren().add(myTriangle);
        });

        menuBar.getMenus().addAll(create,activate,save,more);

        Text text=new Text();
        text.setText("Byo");
        text.setX(100);
        text.setY(100);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.GREENYELLOW);

        Line line=new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.1);
        line.setRotate(45);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.GREEN);
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.YELLOW);

        Polygon triangle =new Polygon();
        triangle.getPoints().setAll(200.0,200.0,
                                    300.0,300.0,
                                    200.0,300.0);
        triangle.setFill(Color.CADETBLUE);


        Circle circle=new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);


        Image image= new Image("file:/C:\\Users\\wziat\\ina\\objektowe\\lista6\\Edytor_graficzny\\src\\main\\java\\app\\edytor_graficzny\\230093-Wall-Paint-Brushes-Brown-Bristles-White-Bgrd-2-1280x1024-1.jpg");
        ImageView imageView=new ImageView(image);
        imageView.setX(400);
        imageView.setY(400);


        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);
        borderPane.setTop(menuBar);
        borderPane.setCenter(root);

        Image icon=new Image("file:/C:\\Users\\wziat\\ina\\objektowe\\lista6\\Edytor_graficzny\\src\\main\\java\\app\\edytor_graficzny\\230093-Wall-Paint-Brushes-Brown-Bristles-White-Bgrd-2-1280x1024-1.jpg");
        stage.getIcons().add(icon);
        stage.setTitle("Edytor graficzny");
        //stage.setHeight(600);
        //stage.setWidth(600);
        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("Press q to exit");
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));



        stage.setScene(scene);
        stage.show();
    }

}
