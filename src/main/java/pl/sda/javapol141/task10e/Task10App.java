package pl.sda.javapol141.task10e;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// utwórz aplikację JavaFx z pustym oknem
// dodaj do pliku module-info.java exports z pakietem aplikacji
public class Task10App extends Application {
    Group root;
    Scene scene;
    Ball ball;
    List<Ball> balls = new ArrayList<>();

    String letter = "V";
    int points;

    Text info = new Text("Liczba punktów: 0");
    ScheduledExecutorService animationExecutor = Executors.newSingleThreadScheduledExecutor();
    ScheduledExecutorService timerExecutor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        scene = new Scene(root, 600, 800);
        ball = new Ball(30, "ball");
        balls = new ArrayList<>(
                IntStream
                        .range(0, 50)
                        .mapToObj(i -> Ball.random(scene.getWidth(), scene.getHeight()))
                        .peek(ball -> ball.setOnMouseClicked(this::handleBall))
                        .toList()
        );
        info.setLayoutX(10);
        info.setLayoutY(20);
        root.getChildren().addAll(balls);
        root.getChildren().add(info);
        stage.setScene(scene);
        stage.setTitle("Bouncing ball");
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(e -> animationExecutor.shutdown());
        animationExecutor.scheduleAtFixedRate(this::animateBalls, 0, 20, TimeUnit.MILLISECONDS);
        scene.setOnKeyPressed(this::handleKeys);
    }

    public void handleBall(MouseEvent event){
        Object source =  event.getSource();
        if (!(source instanceof Ball)){
            return;
        }
        Ball ball = (Ball) source;
        String text = ball.getText().getText();
        if (Objects.equals(text, letter)){
            points++;
            info.setText("Liczba punktów: " + points);
            timerExecutor.schedule(() -> {
                animationExecutor.shutdown();
                timerExecutor.shutdown();
                Platform.exit();
            }, 5, TimeUnit.SECONDS);
        }
    }

    public void handleKeys(KeyEvent event) {
        switch (event.getCode()) {
            case A:
                // zadanie 1
                // usunąć kulki o promieniu większym od 30
                // stwórz listę kulek do usunięcia - removed
                // usuń obiekty w kolekcji balls, które są w removed
                List<Ball> removed = balls.stream().filter(b -> b.getCircle().getRadius() > 30).toList();
                balls.removeAll(removed);
                root.getChildren().removeAll(removed);
                // Przykład klasycznego usuwania elementów
//                List<Ball> removedList = new ArrayList<>();
//                for (var ball: balls){
//                    if (ball.getCircle().getRadius() > 30){
//                        removedList.add(ball);
//                    }
//                }
//                for (var r: removedList){
//                    balls.remove(r);
//                }
                break;
            case B:
                // Zadanie 2
                // utwórz listę łańcuchów (łańcuch z pola text) ze wszystkich kulek
                // wyświetl listę w konsoli - println
                var texts = balls
                        .stream()
                        .map(b -> b.getText().getText())
                        .sorted()
                        .toList();
                System.out.println(texts);
                break;
            case C:
                // Zdanie 3
                // czy można ułożyć słowo z liter w kulkach np. kalkulator
                Map<String, Long> letters = balls
                        .stream()
                        .map(b -> b.getText().getText())
                        .map(String::toUpperCase)
                        .sorted()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
                System.out.println(letters);
                String word = "kalkulator".toUpperCase();
                Map<String, List<String>> wordLetters = word
                        .chars()
                        .mapToObj(c -> (char) (c) + "")
                        .collect(Collectors.groupingBy(Function.identity()));
                boolean isWord = true;
                for (var letter : wordLetters.entrySet()) {
                    if (
                            !letters.containsKey(letter.getKey()) ||
                                    letter.getValue().size() > letters.get(letter)) {
                            isWord = false;
                            break;
                    }
                }
                System.out.println("Czy słowo " + word +" składa się z litera w kulkach? " + isWord);
                break;
            case Q:
                animationExecutor.shutdown();
                Platform.exit();
        }
    }

    public void animateBalls() {
        balls.forEach(this::animateBall);
    }

    public void animateBall(Ball currentBall) {
        if (currentBall.getLayoutX() + currentBall.getWidth() > scene.getWidth()) {
            currentBall.setSpeedX(-currentBall.getSpeedX());
        }
        if (currentBall.getLayoutX() < 0) {
            currentBall.setSpeedX(-currentBall.getSpeedX());
        }
        if (currentBall.getLayoutY() + currentBall.getHeight() > scene.getHeight()) {
            currentBall.setSpeedY(-currentBall.getSpeedY());
        }
        if (currentBall.getLayoutY() < 0) {
            currentBall.setSpeedY(-currentBall.getSpeedY());
        }
        Platform.runLater(() -> {
            //ball.getTransforms().add(Transform.translate(1, 0));
            currentBall.move();
        });


    }

}
