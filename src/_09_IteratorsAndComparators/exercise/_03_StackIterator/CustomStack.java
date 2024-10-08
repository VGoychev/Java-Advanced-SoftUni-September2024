package _09_IteratorsAndComparators.exercise._03_StackIterator;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.Stack;


public class CustomStack implements Iterable<Integer> {
    private Stack<Integer> stack;
    private int index;

    public CustomStack(){
        this.stack = new Stack<>();
        this.index = -1;
    }
    public Stack<Integer> getStack() {
        return stack;
    }
    public void push(Integer... arg){
        Integer[] input = arg;
        for (int i = 0; i < arg.length; i++) {
            stack.push(input[i]);
        }
        this.index = this.stack.size();
    }
    public void pop() throws OperationNotSupportedException {
        if (this.stack.size() != 0){
            this.stack.pop();
            this.index--;
        } else {
            throw new OperationNotSupportedException("No elements");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int position = index;

            @Override
            public boolean hasNext(){
                return position > 0;
            }

            @Override
            public Integer next(){
                return stack.get(position--);
            }
        };
    }
}
