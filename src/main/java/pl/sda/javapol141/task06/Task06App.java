package pl.sda.javapol141.task06;

import pl.sda.javapol141.task01.Point;

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
    }

    public static void printEntries(TreeMap<?,?> treeMap){
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
    }
}
