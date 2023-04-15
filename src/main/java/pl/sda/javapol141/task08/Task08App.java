package pl.sda.javapol141.task08;

public class Task08App {
    public static void main(String[] args) {
        Parcel parcel = Parcel.of(40,40,40, 25, false, new MyValidator());

        System.out.println(parcel);
        parcel = Parcel.of(40,40,40, 55, false, p -> p.getWeight() < 45);
    }
}
