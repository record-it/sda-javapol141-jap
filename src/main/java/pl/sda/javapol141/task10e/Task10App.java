package pl.sda.javapol141.task10e;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

// utwórz aplikację JavaFx z pustym oknem
// dodaj do pliku module-info.java exports z pakietem aplikacji
public class Task10App extends Application {
    Group root;
    Scene scene;

    Ball ball;
    List<Ball> balls = new ArrayList<>();
    ScheduledExecutorService  executor = Executors.newSingleThreadScheduledExecutor();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        scene = new Scene(root, 600, 800);
        ball = new Ball(30, "ball");
        root.getChildren().add(ball);
        balls = IntStream.range(0, 100).mapToObj(i -> Ball.random(scene.getWidth(), scene.getHeight())).toList();
        root.getChildren().addAll(balls);
        stage.setScene(scene);
        stage.setTitle("Bouncing ball");
        stage.setResizable(false);
        stage.show();
        ball.setSpeedX(3);
        ball.setSpeedY(2);
        executor.scheduleAtFixedRate(this::animateBalls, 0, 20, TimeUnit.MILLISECONDS);
    }

    public void animateBalls(){
        balls.forEach(this::animateBall);
    }

    public void animateBall(Ball currentBall){
        if (currentBall.getLayoutX() + currentBall.getWidth() > scene.getWidth()) {
            currentBall.setSpeedX(-currentBall.getSpeedX());
        }
        if(currentBall.getLayoutX() < 0){
            currentBall.setSpeedX(-currentBall.getSpeedX());
        }
        if (currentBall.getLayoutY() + currentBall.getHeight() > scene.getHeight()) {
            currentBall.setSpeedY(-currentBall.getSpeedY());
        }
        if(currentBall.getLayoutY() < 0){
            currentBall.setSpeedY(-currentBall.getSpeedY());
        }
        Platform.runLater(() -> {
            //ball.getTransforms().add(Transform.translate(1, 0));
            currentBall.move();
        });


    }

}
