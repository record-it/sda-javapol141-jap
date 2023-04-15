package pl.sda.javapol141.task04;

import java.util.*;

public class Storage {
    private final Map<String, Collection<String>> map;

    public Storage() {
        map = new HashMap<>();
    }

    public void addToStorage(String key, String value){
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }

    /**
     * Zaimplementuj metodę,  wyświetl posortowane łańcuchy
     * @param key
     */
    public void printValues(String key){
        Collection<String> list = map.get(key);
        if (list == null){
            return;
        }
        System.out.println(list.stream().sorted().toList());
    }

    public void findValues(String value){
        List<String> keys = new ArrayList<>();
        for(var entry: map.entrySet()){
            if (entry.getValue().contains(value)){
                keys.add(entry.getKey());
            }
        }
        System.out.println(keys);
    }
}
