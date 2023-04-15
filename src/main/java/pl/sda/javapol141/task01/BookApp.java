package pl.sda.javapol141.task01;

import java.util.ArrayList;
import java.util.List;

public class BookApp {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(
          List.of(
                  Book
                          .builder()
                          .title("Java")
                          .author("Bloch")
                          .editionYear(2020)
                          .copies(3)
                          .build(),
                  Book
                          .builder()
                          .title("Spring")
                          .author("Pivotal")
                          .editionYear(2022)
                          .copies(6)
                          .build(),
                  Book
                          .builder()
                          .title("Java for beginners")
                          .author("Freeman")
                          .editionYear(2021)
                          .copies(2)
                          .build(),
                  Book
                          .builder()
                          .title("JDBC")
                          .author("Bloch")
                          .editionYear(2020)
                          .copies(6)
                          .build()
          )
        );
        books.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));
        // posortuj książki wg autorów - Zadanie 1

        // posortuj książki wg roku edycji - Zadanie 2

        System.out.println(books);
    }
}
