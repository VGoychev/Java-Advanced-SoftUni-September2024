package _08_Generics.lab._03_GenericScale;

//Искам елементите, да бъдат сравними със себе си -- Comparable<E>
public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;
    public Scale(T left, T right){
        this.left = left;
        this.right = right;
    }
    public T getHeavier(){
        if (this.left.compareTo(this.right) == 0) {
            return this.left;
        }
        if (this.left.compareTo(this.right) < 0){
            return right;
        }
        return null;
    }
}
