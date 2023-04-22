package pl.sda.javapol141.task32;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.sda.javapol141.task01.Book;

import java.util.ArrayList;
import java.util.List;

public class Task32App extends Application {
    Stage stage;
    Scene scene;
    GridPane root;
    TextField bookTitle;
    List<Book> books = new ArrayList<>();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        root = new GridPane();
        createLayout(root);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void createLayout(GridPane pane){
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(new Label("Tytuł: "), 0, 0);
        bookTitle = new TextField();
        pane.add(bookTitle, 1, 0);
    }
}
