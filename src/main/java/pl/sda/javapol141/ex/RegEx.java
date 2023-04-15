package pl.sda.javapol141.ex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        String kod = "fd dgffd 1900 dfgdfg 2202 dfgd gd";
        // \\s
        Pattern pattern = Pattern.compile("(\\s\\d\\d\\d\\d\\s)");

        Matcher matcher = pattern.matcher(kod);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
        // metoda nieefektywny, kompilowanie tylko dla jednego sprawdzenia
        System.out.println("2000".matches("\\d{4,6}"));
    }
}
