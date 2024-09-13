package _02_MultiDimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = input[0];

        int [] [] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = arr;
        }
        int n = Integer.parseInt(scanner.nextLine());

        compareNumber(n,matrix);
    }
    private static void compareNumber(int n, int[][] matrix){
        boolean equal = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (n == matrix[row][col]){
                    System.out.println(row + " " + col);
                    equal = true;
                }
            }
        }
        if (!equal){
            System.out.println("not found");
        }
    }
}
