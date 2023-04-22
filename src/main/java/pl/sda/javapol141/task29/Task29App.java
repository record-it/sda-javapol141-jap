package pl.sda.javapol141.task29;

import java.lang.reflect.Array;
import java.util.function.Predicate;

public class Task29App {
    public static void main(String[] args) {
        String[] names = {"Ala", "Adam", "Ola", "Karol"};
        final double percent = partOf(names, name -> name.length() == 3);
        System.out.println(percent);
        System.out.println(partOf(new Integer[]{5, 4}, i -> i % 2 == 0));
    }

    public static <T> double partOf(T[] arr, Predicate<T> filter){
        // umieść pętlę for each dla tablicy arr
        int counter = 0;
        for(var item: arr){
            if (filter.test(item)){
                counter++;
            }
        }
        return ((double) counter / arr.length);
    }
}
