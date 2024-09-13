package MultiDimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][]matrix = new int [n][n];
        for (int row = 0; row < n; row++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = array;
        }
        int sumSecondary = 0;
        int sumPrimary = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int number = matrix[row][col];
                if (row == col){
                    sumPrimary += number;
                }
            }
        }
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            int number = matrix[row][col];
            sumSecondary += number;
            col++;
        }

        int difference = sumPrimary - sumSecondary;
        if (difference < 0){
            difference = difference * -1;
        }

        System.out.println(difference);
    }
}
