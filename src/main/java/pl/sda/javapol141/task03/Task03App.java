package pl.sda.javapol141.task03;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Task03App {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.putIfAbsent("Java", 18);
        map.putIfAbsent("Python", 1);
        map.putIfAbsent("PHP", 0);
        printMap(map);
    }
    private static void printMap(Map<String, Integer> map) {
        String result = map
                .entrySet()
                .stream()
                .map(entry -> "Klucz: " + entry.getKey() + ", Wartość: " + entry.getValue())
                .collect(Collectors.joining(",\n")) + ".";
        System.out.println(result);
    }


}
