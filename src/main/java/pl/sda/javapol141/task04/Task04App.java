package pl.sda.javapol141.task04;

public class Task04App {
    public static void main(String[] args) {
        var storage = new Storage();
        storage.addToStorage("Adam", "Nowak");
        storage.addToStorage("Adam", "Kowal");
        storage.addToStorage("Ewa", "Nowak");
        storage.addToStorage("Ala", "Abecka");
        storage.printValues("Adam");
    }

}
