package MultiDimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][]matrix = new int [n][n];
        for (int row = 0; row < n; row++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = array;
        }
        int[][] outputMatrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int number = matrix[row][col];
                if (row == col){
                    System.out.print(number + " ");
                }
            }
        }
        System.out.println();
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            int number = matrix[row][col];
            System.out.print(number + " ");
            col++;
        }
    }
}
