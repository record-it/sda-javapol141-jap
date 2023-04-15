package pl.sda.javapol141.task01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int editionYear;
    private int copies;
}
