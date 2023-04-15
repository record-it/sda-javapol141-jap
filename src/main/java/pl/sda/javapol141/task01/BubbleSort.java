package pl.sda.javapol141.task01;

import java.util.Comparator;

/**     I  II
 *   3  2  2
 *   6  3  3
 *   2  6  6
 *   8  8  8
 *   9  9  9
 */
public class BubbleSort {
    public static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = arr.length - 1; j > i; j--){
                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void sort(int[] arr, Comparator<Integer> comparator){
        for(int i = 0; i < arr.length; i++){
            for(int j = arr.length - 1; j > i; j--){
                if (comparator.compare(arr[j], arr[j-1]) > 1){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static <T> void sort(T[] arr, Comparator<T> comparator){
        for(int i = 0; i < arr.length; i++){
            for(int j = arr.length - 1; j > i; j--){
                if (comparator.compare(arr[j], arr[j-1]) < 0){
                    T temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
