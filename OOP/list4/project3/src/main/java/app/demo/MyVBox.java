package app.demo;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MyVBox extends VBox {
    private final TextField input=new TextField();
    private final TextArea output=new TextArea();
    public MyVBox(){}
    public void MyVBoxmethod(Stage stage){
        input.setMaxWidth(100);
        input.setAlignment(Pos.CENTER);
        this.getChildren().add(input);

        //output.setText("Cokolwiek");
        MyButton mbt=new MyButton();
        mbt.Mybuttonmethod(this,stage);
        this.getChildren().add(mbt);

        //output.setText(TextAlignment.CENTER);
        this.getChildren().add(output);

        this.setSpacing(10);
        this.setMinSize(300,300);
        this.setAlignment(Pos.CENTER);
    }
    public final String getInput(){
        return input.getText();
    }
    public final void setOutput(String text){
        output.appendText(text);
    }
    public final void outputClear(){
        output.clear();
    }


}
