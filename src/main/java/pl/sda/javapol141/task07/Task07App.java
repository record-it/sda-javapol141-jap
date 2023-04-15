package pl.sda.javapol141.task07;

public class Task07App {
    public static void main(String[] args) {
        CartidgeBox box = new CartidgeBox(1);
        box.loadBullet("aa");
        if (box.isLoaded()){
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed");
        }
        box.shot();
        if (!box.isLoaded()){
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed");
        }
    }
}
