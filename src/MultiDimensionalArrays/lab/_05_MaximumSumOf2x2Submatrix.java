package MultiDimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int[] input = Arrays.stream(scanner.nextLine().split(", "))
                 .mapToInt(Integer::parseInt).toArray();
         int rows = input[0];
         int cols = input[1];
         int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = elements;
        }

        int totalSum = 0;
        int[][] outputMatrix = new int[2][2];
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > totalSum){
                    totalSum = currentSum;
                    outputMatrix[0]=new int[] {matrix[row][col], matrix[row][col + 1]};
                    outputMatrix[1]=new int[] {matrix[row + 1][col], matrix[row + 1][col + 1]};
                }
            }
        }
        for (int row = 0; row < outputMatrix.length; row++) {
            for (int col = 0; col < outputMatrix[row].length; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(totalSum);
    }
}
