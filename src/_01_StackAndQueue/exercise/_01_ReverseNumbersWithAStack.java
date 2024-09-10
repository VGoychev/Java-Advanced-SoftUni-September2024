package _01_StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] tokens = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int token : tokens){
            stack.push(token);
        }

        while (stack.size() != 0){
            int element = stack.pop();
            System.out.print(element + " ");
        }
    }
}
