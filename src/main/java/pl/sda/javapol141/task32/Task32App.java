package pl.sda.javapol141.task32;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import pl.sda.javapol141.task01.Book;
import pl.sda.javapol141.task01.Point;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task32App extends Application {
    Stage stage;
    Scene scene;
    GridPane root;
    TextField bookTitle;
    TextField bookAuthor;
    TextField bookEditionYear;
    TextField bookCopies;
    ListView<Book> booksView;
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
        // dodaj pozostałe pola formularza: autor, rok wydania, liczba kopii
        pane.add(new Label("Autor: "), 0, 1);
        bookAuthor = new TextField();
        pane.add(bookAuthor, 1, 1);

        pane.add(new Label("Rok wydania: "), 0, 2);
        bookEditionYear = new TextField();
        pane.add(bookEditionYear, 1, 2);

        pane.add(new Label("Liczba kopii: "), 0, 3);
        bookCopies = new TextField();
        pane.add(bookCopies, 1, 3);

        Button addBookBtn = new Button("Dodaj");
        addBookBtn.setOnMouseClicked(this::setClickAddBookBtn);
        Button saveBookSBtn = new Button("Zapisz");
        saveBookSBtn.setOnMouseClicked(this::setClickSaveBooksBtn);
        Button loadBooksBtn = new Button("Wczytaj");
        loadBooksBtn.setOnMouseClicked(this::setClickLoadBooksBtn);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        vBox.getChildren().add(addBookBtn);
        vBox.getChildren().add(saveBookSBtn);
        vBox.getChildren().add(loadBooksBtn);

        addBookBtn.setMinWidth(200);
        saveBookSBtn.setMinWidth(200);
        loadBooksBtn.setMinWidth(200);

        pane.add(vBox,0,6,2,1);
        pane.setAlignment(Pos.CENTER);

        booksView = new ListView<>();
        booksView.setCellFactory(new Callback<ListView<Book>, ListCell<Book>>() {
            @Override
            public ListCell<Book> call(ListView<Book> bookListView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Book book, boolean b) {
                        super.updateItem(book, b);
                        if (book != null){
                            setText(book.toString());
                            setFont(Font.font("Courier New", 14));
                        }
                    }
                };
            }
        });
        booksView.setMinWidth(500);
        pane.add(booksView, 0, 7, 2, 1);
        booksView.getItems().add(Book
                .builder()
                        .title("Java")
                        .author("Bloch")
                        .copies(2)
                        .editionYear(2020)
                .build()
        );
    }

    private void setClickAddBookBtn(MouseEvent event){
        final int editionYear = Integer.parseInt(bookEditionYear.getText());
        final int copies = Integer.parseInt(bookCopies.getText());
        final String author = bookAuthor.getText();
        final String title = bookTitle.getText();
        Book book = Book
                .builder()
                .title(title)
                .author(author)
                .copies(copies)
                .editionYear(editionYear)
                .build();
        booksView.getItems().add(book);
    }

    private void setClickSaveBooksBtn(MouseEvent event){
        FileChooser chooser = new FileChooser();
        final File file = chooser.showSaveDialog(stage);
        if (file == null){
            return;
        }
        // zapisz zawartość kolekcji w booksView do pliku file
        Path path = Paths.get(file.getAbsolutePath());
        try {
            Files.writeString(path,
                    booksView
                            .getItems()
                            .stream()
                            .map(book -> book.toString())
                            .collect(Collectors.joining(System.lineSeparator()
                            )));
        } catch (IOException e) {
            System.err.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Zapis do pliku nie powiódł się!");
            alert.show();
        }


    }

    private void setClickLoadBooksBtn(MouseEvent event){

    }

}
