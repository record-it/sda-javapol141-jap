package pl.sda.javapol141.task10e;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

public class Ball extends StackPane {
    private static final Random random = new Random();
    private Circle circle;

    private Text text;

    private double speedX;

    private double speedY;

    public Ball(double radius, String content){
        circle = new Circle(0,0, radius);
        speedX = 1;
        speedY = 1;
        RadialGradient gradient = new RadialGradient(
                0,
                .1,
                0,
                0,
                radius,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.WHITESMOKE),
                new Stop(1, Color.BLUEVIOLET)
        );
        circle.setFill(gradient);
        this.text = new Text(getLayoutX(), getLayoutY(), content);
        this.text.setFont(Font.font("Arial", 18));
        this.getChildren().addAll(this.circle, this.text);
        this.setAlignment(Pos.CENTER);
    }

    public Ball(double radius, String content, Color color){
        circle = new Circle(0,0, radius);
        speedX = 1;
        speedY = 1;
        RadialGradient gradient = new RadialGradient(
                0,
                .1,
                0,
                0,
                radius,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.WHITESMOKE),
                new Stop(1, color)
        );
        circle.setFill(gradient);
        this.text = new Text(getLayoutX(), getLayoutY(), content);
        this.text.setFont(Font.font("Arial", 18));
        this.getChildren().addAll(this.circle, this.text);
        this.setAlignment(Pos.CENTER);
    }
    public static Ball random(double width, double height){
        String randomText = ((char) (65 + random.nextInt(25))) + "";
        Color color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        var ball = new Ball(10 + random.nextInt(30), randomText, color);
        ball.setSpeedX(1 + random.nextDouble(6));
        ball.setSpeedY(1 + random.nextDouble(6));
        ball.setLayoutX(random.nextDouble(width));
        ball.setLayoutY(random.nextDouble(height));
        return ball;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void move(){
        this.setLayoutX(this.getLayoutX() + speedX);
        this.setLayoutY(this.getLayoutY() + speedY);
    }
}
