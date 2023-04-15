package pl.sda.javapol141.task04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private final Map<String, List<String>> map;

    public Storage() {
        map = new HashMap<>();
    }

    public void addToStorage(String key, String value){
        map.putIfAbsent(key, new ArrayList<>());
        List<String> names = map.get(key);
        names.add(value);
    }

    /**
     * Zaimplementuj metodę,  wyświetl posortowane łańcuchy
     * @param key
     */
    public void printValues(String key){
        List<String> list = map.get(key);
        if (list == null){
            return;
        }
        System.out.println(list.stream().sorted().toList());
    }
}
