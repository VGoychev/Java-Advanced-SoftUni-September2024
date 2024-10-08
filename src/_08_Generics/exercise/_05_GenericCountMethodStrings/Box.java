package _08_Generics.exercise._05_GenericCountMethodStrings;

import java.util.List;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T value;

    public Box(T value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",this.value.getClass().getName(), this.value);
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.value.compareTo(o.value);
    }
}
