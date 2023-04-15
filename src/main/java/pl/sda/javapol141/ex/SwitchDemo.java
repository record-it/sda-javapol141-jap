package pl.sda.javapol141.ex;

import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Add");
            System.out.println("Dodaj");
            System.out.println("Sub");
            System.out.println("Mul");
            System.out.println("Quit");
            String command = scanner.nextLine();
            switch (command){
                case "Add":
                case "Dodaj":
                    System.out.println("Dodawanie");
                    break;
                case "Quit":
                    return;
            }
            // wiemy ile razy wykonają sie powtórzenia, lepiej stosować for
            int count = 0;
            while(count < 3){
                count++;
            }
            for(int i = 0; i < 3 ; i++){
                System.out.println("????");
            }
        }
    }

}
