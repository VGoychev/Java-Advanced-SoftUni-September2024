package _Exam.Task_02_;

import java.util.Arrays;
import java.util.Scanner;

public class Task_02_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int n = dimensions[0];
        int m = dimensions[1];
        char[][] field = new char[n][m];
        fillMatrix(scanner, field);
        int time = 16;
        int[] coordinates = findStartPosition(field);

        while (time > 0) {
            String command = scanner.nextLine();
            if (!command.equals("defuse")) {
                move(command, coordinates, field);
                time--;
            } else {
                time = defuseBomb(coordinates, field, time);
                if (time == -1) {
                    break;
                }
            }

            if (field[coordinates[0]][coordinates[1]] == 'T') {
                field[coordinates[0]][coordinates[1]] = '*';
                System.out.println("Terrorists win!");
                break;
            }
        }

        printMatrix(field);
    }

    private static void move(String command, int[] coordinates, char[][] field) {
        int newRow = coordinates[0];
        int newCol = coordinates[1];
        switch (command) {
            case "up":
                newRow--;
                break;
            case "down":
                newRow++;
                break;
            case "left":
                newCol--;
                break;
            case "right":
                newCol++;
                break;
        }

        if (isInBounds(newRow, newCol, field)) {
            coordinates[0] = newRow;
            coordinates[1] = newCol;
        }
    }

    private static int defuseBomb(int[] coordinates, char[][] field, int time) {
        if (field[coordinates[0]][coordinates[1]] == 'B') {
            if (time >= 4) {
                field[coordinates[0]][coordinates[1]] = 'D';
                time -= 4;
                System.out.println("Counter-terrorist wins!");
                System.out.println("Bomb has been defused: " + time + " second/s remaining.");
                return -1;
            } else {
                field[coordinates[0]][coordinates[1]] = 'X';
                int timeNeeded = 4 - time;
                System.out.println("Terrorists win!");
                System.out.println("Bomb was not defused successfully!");
                System.out.println("Time needed: " + timeNeeded + " second/s.");
                return -1;
            }
        } else {
            time -= 2;
        }
        return time;
    }

    private static void fillMatrix(Scanner scanner, char[][] field) {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }
    }

    private static int[] findStartPosition(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'C') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static void printMatrix(char[][] field) {
        for (char[] row : field) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[0].length;
    }
}
