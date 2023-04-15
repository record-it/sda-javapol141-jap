package pl.sda.javapol141.task01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Zadanie 3
 * Zdefiniuj metodę compareTo dla klasy Point
 * kolejność wg pola x a potem y
 * stwórz przykładową aplikację z sortowaniem obiektów klasy Point
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    private double x;
    private double y;
}
