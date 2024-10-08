package _09_IteratorsAndComparators.exercise._01_ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> list;
    private int currentIndex;

    public ListyIterator(String... elements){
        this.list = new ArrayList<>(Arrays.asList(elements));
        this.currentIndex = 0;
    }

    public boolean move(){
       if (hasNext()){
           this.currentIndex++;
           return true;
       }

       return false;

    }
    public boolean hasNext(){
        if (this.currentIndex < this.list.size() - 1) {
            return true;
        }
        return false;
    }
    public void print(){
        if (this.list.size() == 0){
            throw new RuntimeException("Invalid Operation!");
        } else {
            System.out.println(this.list.get(currentIndex));
        }
    }
}
