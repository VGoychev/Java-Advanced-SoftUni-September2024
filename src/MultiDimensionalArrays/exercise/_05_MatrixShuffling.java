package MultiDimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String [rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] array = scanner.nextLine().split(" ");
            matrix[row] = array;
        }
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(" ");

            if (!tokens[0].equals("swap") || tokens.length != 5){
                System.out.println("Invalid input!");
            } else {

                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                if (row1 > rows - 1 || row2 > rows - 1 || col1 > cols - 1 || col2 > cols - 1 || row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0) {
                    System.out.printf("Invalid input!%n");
                } else {
                    String element1 = matrix[row1][col1];
                    String element2 = matrix[row2][col2];

                    matrix[row1][col1] = element2;
                    matrix[row2][col2] = element1;

                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[row].length; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                }
            }
            command = scanner.nextLine();
        }

    }
}
