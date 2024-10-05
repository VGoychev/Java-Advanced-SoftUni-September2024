package _08_Generics.exercise._07_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Comparable<T> {
    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();
    }
    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        return this.list.remove(index);
    }
    public boolean contains(T element){
        return this.list.contains(element);
    }
    public void swap(int first, int second){
        T firstElement = this.list.get(first);
        T secondElement = this.list.get(second);
        this.list.set(first, secondElement);
        this.list.set(second,firstElement);
    }
    public int count(T element){
        int counter = 0;
        for (T t : this.list){
            int result = t.compareTo(element);
            if (result > 0){
                counter++;
            }
        }
        return counter;
    }

    public T getMax(){
        return Collections.max(this.list);
    }

    public T getMin(){
        return Collections.min(this.list);
    }

    public int size(){
        return this.list.size();
    }

    public T get(int element){
        return this.list.get(element);
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
