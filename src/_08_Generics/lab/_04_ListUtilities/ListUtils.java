package _08_Generics.lab._04_ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    //Искам списък с елементи, които да бъдат сравними със себе си -- Comparable<E>
    public static <E extends Comparable<E>> E getMin(List<E> list){
        return Collections.min(list);
    }

    public static <E extends Comparable<E>> E getMax(List<E> list){
        return Collections.max(list);
    }
}
