package pl.sda.javapol141.task01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int editionYear;
    private int copies;

    @Override
    public int compareTo(Book o) {
        if (o == null){
            return 1;
        }
        if (title == null){
            return -1;
        }
        if (title.compareToIgnoreCase(o.title) == 0){
            if (author.compareToIgnoreCase(o.author) == 0){
                if (editionYear == o.editionYear){
                    return Integer.compare(copies, o.copies);
                } else {
                    return Integer.compare(editionYear, o.editionYear);
                }
            } else {
                return author.compareToIgnoreCase(o.author);
            }
        } else {
            return title.compareToIgnoreCase(o.title);
        }

    }
}
