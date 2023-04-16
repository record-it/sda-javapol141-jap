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
        executor.scheduleAtFixedRate(this::animateBall, 0, 20, TimeUnit.MILLISECONDS);
    }

    public void animateBall(){
        if (ball.getLayoutX() + ball.getWidth() > scene.getWidth()) {
            ball.setSpeedX(-ball.getSpeedX());
        }
        if(ball.getLayoutX() < 0){
            ball.setSpeedX(-ball.getSpeedX());
        }
        if (ball.getLayoutY() + ball.getHeight() > scene.getHeight()) {
            ball.setSpeedY(-ball.getSpeedY());
        }
        if(ball.getLayoutY() < 0){
            ball.setSpeedY(-ball.getSpeedY());
        }
        Platform.runLater(() -> {
            //ball.getTransforms().add(Transform.translate(1, 0));
            ball.move();
        });


    }

}
