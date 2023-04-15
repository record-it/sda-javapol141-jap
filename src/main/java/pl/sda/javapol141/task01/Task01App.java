package pl.sda.javapol141.task01;

import java.sql.Array;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Task01App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                List.of("Żaneta", "Aneta","Beata","Adam", "Robert", "Łukasz")
        );
        sortPlAscending(names);
        System.out.println(names);
        sortPlADescending(names);
        System.out.println(names);
        int[] numbers = {1, 4, 7, 2, 4, 9, 8};
        BubbleSort.sort(numbers, (a, b) -> b - a);
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        var arrNames = names.toArray();
        BubbleSort.sort(arrNames, Collator.getInstance(Locale.forLanguageTag("pl-PL")));
        System.out.println(Arrays.toString(arrNames));
    }

    public static List<String> sortPlAscending(List<String> list){
        var pl = Locale.forLanguageTag("pl-PL");
        var plCollator = Collator.getInstance(pl);
        list.sort(plCollator);
        return list;
    }
    public static List<String> sortPlADescending(List<String> list) {
        var pl = Locale.forLanguageTag("pl-PL");
        var plCollator = Collator.getInstance(pl).reversed();
        list.sort(plCollator);
        return list;
    }





}
