package pl.sda.javapol141.task06;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10_000_000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100_000);
        }
        System.out.println("Wyszukiwanie liniowe ...");
        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 8){
                System.out.println("8 at " + i);
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));
        Arrays.sort(arr);
        System.out.println("Wyszukiwanie metodą binary search ...");
        start = System.nanoTime();
        int index8 = Arrays.binarySearch(arr, 8);
        end = System.nanoTime();
        System.out.println("8 at " + index8);
        System.out.println("Time: " + (end - start));
    }
}
