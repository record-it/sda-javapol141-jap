package pl.sda.javapol141.task06;

import pl.sda.javapol141.task01.Book;
import pl.sda.javapol141.task01.Point;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Task06App {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.putIfAbsent("R", 2);
        map.putIfAbsent("A", 5);
        map.putIfAbsent("B", 3);
        printEntries(map);
        TreeMap<Point, Double> points = new TreeMap<>();
        // dodaj do mapy points kilka punktów np. new Point(2, 3), new Point(2, 6) itd.
        points.put(new Point(2, 3), 34.5);
        points.put(new Point(1, 3), 34.5);
        points.put(new Point(2, 1), 34.5);
        // wywołaj metodę printEntries dla points
        printEntries(points);
        TreeMap<Book, Long> books = new TreeMap<>((a, b) -> a.getCopies() - b.getCopies());
        books.putIfAbsent(Book.builder().copies(3).build(), 6L);
        books.putIfAbsent(Book.builder().copies(9).build(), 16L);
        books.putIfAbsent(Book.builder().copies(2).build(), 65L);
        printEntries(books);
        TreeMap<LocalDate, String> calendar = new TreeMap<>((a, b) -> b.compareTo(a));
        calendar.put(LocalDate.of(2023, 4, 20), "Urodziny");
        calendar.put(LocalDate.of(2023, 4, 17), "Zakupy");
        calendar.put(LocalDate.of(2023, 4, 25), "Wyjazd");
        printEntries(calendar);
    }

    public static void printEntries(TreeMap<?,?> treeMap){
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
    }

    // 2, 6 ,7 ,8 ,3, 4, 9
    // 2, 3, 4, 6, 7, 8, 9
    //       4
    //     3   7
    //   2   6   8
    //              9
}
