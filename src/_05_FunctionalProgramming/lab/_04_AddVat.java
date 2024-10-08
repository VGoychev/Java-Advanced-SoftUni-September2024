package _05_FunctionalProgramming.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class _04_AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        List<Double> numbers = new ArrayList<>();
        for (String s : input){
            numbers.add(Double.parseDouble(s));
        }
        UnaryOperator<Double> addVat = x -> x * 1.2;
        System.out.println("Prices with VAT: ");
        for (Double str : numbers){
            System.out.printf("%.2f%n", addVat.apply(str));
        }
    }
}
