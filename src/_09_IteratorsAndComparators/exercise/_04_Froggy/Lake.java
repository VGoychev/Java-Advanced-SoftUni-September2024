package _09_IteratorsAndComparators.exercise._04_Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer>{
    private int[] stones;

    public Lake(int... stones){
        this.stones = stones;
    }
    public Iterator<Integer> iterator(){
        return new Frog();
    }


    private class Frog implements Iterator<Integer> {
        private int index = 0;

        public boolean hasNext(){
            return this.index < stones.length;
        }

        public Integer next(){
            int value;
            if (index >= stones.length) {
                index = 1;
            }
            value = stones[this.index];
            this.index += 2;
            if (this.index % 2 == 0 && !hasNext()) {
                this.index = 1;
            }
            return value;
        }
    }
}
