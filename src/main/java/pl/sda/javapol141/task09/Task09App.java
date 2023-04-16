package pl.sda.javapol141.task09;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Task09App extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        MyCircle circle = new MyCircle(new Point2D(100, 100), new Point2D(100, 50));
        circle.setFill(Color.BLUE);
        circle.setStrokeWidth(3);
        circle.setStroke(Color.RED);
        String info = "Obwód = " + circle.getPerimeter() + ", pole = " + circle.getArea();
        Text text = new Text(10, 20, info);
        root.getChildren().addAll(circle, text);
        Scene scene = new Scene(root, 400, 600);
        stage.setScene(scene);
        stage.show();
    }
}
