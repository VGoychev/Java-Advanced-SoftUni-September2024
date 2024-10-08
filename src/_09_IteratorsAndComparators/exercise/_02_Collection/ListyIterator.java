package _09_IteratorsAndComparators.exercise._02_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements){
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.currentIndex = 0;
    }

    public boolean move(){
        if (hasNext()){
            this.currentIndex++;
            return true;
        }
        return false;
    }
    public void print(){
        if (this.elements.size() == 0){
            throw new RuntimeException("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(currentIndex));
        }
    }
    public boolean hasNext(){
        if (this.currentIndex < this.elements.size() - 1){
            return true;
        }
        return false;
    }
    public void printAll(){
        for (String element : elements){
            System.out.print(String.format("%s ", element));
        }
            System.out.println();
    }
    public Iterator<String> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<String>{
       private int index = 0;
        public boolean hasNext(){
            if (this.index < elements.size() - 1){
                return true;
            }

            return false;
        }

        public String next(){
            return elements.get(index++);
        }
    }

}
