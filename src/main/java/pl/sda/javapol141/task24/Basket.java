package pl.sda.javapol141.task24;

import java.lang.reflect.Array;
import java.util.Objects;

public class Basket<T> {
    private final static int CAPACITY = 10;
    private int last = -1;
    // [item1,null,item3,item4,,,,,,,]
    private T[] content;

    public Basket(Class<T> clazz){
        content = (T[]) Array.newInstance(clazz, CAPACITY);
    }

    public void addToBasket(T item){
        // sprawdzić, czy jest miejsce w tablicy i zgłisić wyjątek jeśli brak

        last ++;
        content[last] = item;
    }

    public void removeFromBasket(T item){
        // sprawdzić czy jest coś w koszyku i zgłosić wyjątek jeśli pusty

        // petla for dla tablicy content
        int index = -1;
        for(int i = 0; i < content.length; i++){
            if (Objects.equals(item, content[i])){
                index = i;
                break;
            }
        }
        if (index == -1){
            return;
        }
        for(int j = index; j < last; j++){
            content[j] = content[j + 1];
        }
        last--;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i <= last; i++){
           sb.append(content[i]).append(System.lineSeparator());
       }
       return sb.toString();
    }

    public boolean isEmpty(){
        return last < 0;
    }

    public boolean isFull(){
        return last >= 9;
    }
}
