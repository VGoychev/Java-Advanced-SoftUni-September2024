package _09_IteratorsAndComparators.lab._04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare(Book book1, Book book2){
        if(book1.getTitle().compareTo(book2.getTitle()) == 0) {
            if (book1.getYear() > book2.getYear()) {
                return 1;
            } else if (book1.getYear() < book2.getYear()){
                return -1;
            }
            return 0;
        } else {
            return book1.getTitle().compareTo(book2.getTitle());
        }

    }
}
