package pl.sda.javapol141.task24;

public class Task24App {
    public static void main(String[] args) {
        Basket<String> basket = new Basket<>(String.class);
        try{
            basket.removeFromBasket("bułka");
            System.out.println("Test 2 failed!");
        } catch (BasketEmptyException e){
            System.out.println("Test 2 passed!");
        }

        for(int i=0; i < 10; i++){
            basket.addToBasket("mleko");
        }

        try{
            basket.addToBasket("bułka");
            System.out.println("Test 1 failed!");
        } catch (BasketFullException e){
            System.out.println("Test 1 passed!");
        }

    }
}
