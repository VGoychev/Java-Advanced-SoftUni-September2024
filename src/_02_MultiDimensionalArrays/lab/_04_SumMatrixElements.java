package _02_MultiDimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] input = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];
        int sum = 0;
        int countRows = 0;
        int countCols = 0;
        for (int row = 0; row < rows; row++) {
            int[] array = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = array;
        }

        for (int row = 0; row < matrix.length; row++) {
            countRows++;
            for (int col = 0; col < matrix[row].length; col++) {
                int number = matrix[row][col];
                sum += number;
            }
            countCols = matrix[row].length;
        }
        System.out.println(countRows);
        System.out.println(countCols);
        System.out.println(sum);
    }
}
