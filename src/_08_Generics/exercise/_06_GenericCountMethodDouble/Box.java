package _08_Generics.exercise._06_GenericCountMethodDouble;

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
