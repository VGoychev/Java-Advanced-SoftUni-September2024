package _09_IteratorsAndComparators.lab._02_Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Iterator<Book> iterator() {
        return new LibIterator();
    }


    private class LibIterator implements Iterator<Book>{
        private int index = 0;
        public boolean hasNext(){
            if(this.index < books.length){
                return true;
            } else {
                return false;
            }
        }

        public Book next(){
            return books[index++];
        }
    }
}
