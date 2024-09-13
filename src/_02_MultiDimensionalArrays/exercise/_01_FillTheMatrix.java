package _02_MultiDimensionalArrays.exercise;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[n][n];

        if (pattern.equals("A")){
            patternA(matrix);
        } else {
            patternB(matrix);
        }
        printMatrix(matrix);


    }

    private static int[][] patternA(int[][] matrix){
        int number = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = number;
                number++;
            }
        }
        return matrix;
    }

    private static int[][] patternB(int[][] matrix){
        int number = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = number;
                    number++;
                }
            }

            }
        return matrix;
        }

    private static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
