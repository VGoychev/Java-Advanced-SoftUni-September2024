package _Exam.Task_02_;

import java.util.Scanner;

public class Task_02_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


    }

    private static void fillMatrix(Scanner scanner, int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }
    }
    private static int[] findStartPosition(int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 'J') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static void printMatrix(char[][] field) {
        for (char[] row : field){
            System.out.println(row);
        }
    }
}
