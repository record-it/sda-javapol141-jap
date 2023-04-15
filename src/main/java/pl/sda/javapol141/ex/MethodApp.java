package pl.sda.javapol141.ex;

public class MethodApp {
    public static void main(String[] args) {
        String b1 = bułka(0.1, 2, 2);
        String b2 = bułka(0.45, 6, 4);
        System.out.println(b2);
        MethodApp app = new MethodApp();
    }

    public String bułka(SkładnikiBułki składniki){
        return "";
    }

    public void zawieźBułkiDoSklepu(int liczba){
        System.out.println("Wiozę bułki");
        System.out.println("Rozpakować bułki");
    }

    public static String bułka(double mąka, double woda, int jajka){
        System.out.println("Weż mąkę");
        System.out.println("Wymieszaj mąkę z wodą");
        int ileBułek = (int) (mąka/0.1);
        return "Bułka".repeat(ileBułek);
    }
}
