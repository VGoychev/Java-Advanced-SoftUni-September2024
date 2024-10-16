package _ExamPreparation_03_.Task_02_;

import java.util.Arrays;
import java.util.Scanner;

public class CollectingStarsGame {

    private static int stars = 2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        fillMatrix(scanner, size, field);

        int[] currentPosition = findStartPosition(size, field);

        while (true) {
            if (stars == 10) {
                System.out.println("You won! You have collected 10 stars.");
                break;
            } else if (stars == 0) {
                System.out.println("Game over! You are out of any stars.");
                break;
            }

            String command = scanner.nextLine();
            assert currentPosition != null;

            movePlayer(command, currentPosition, field, size);
            handleBoundariesToOrigin(currentPosition, size);
            handleCurrentPosition(currentPosition, field);

        }
        finalPositionPrint(currentPosition);

        for (char[] chars : field) {
            System.out.println(String.join(" ", Arrays.toString(chars).replaceAll("[\\[\\],]", "")));
        }
    }

    private static void finalPositionPrint(int[] currentPosition) {
        System.out.println("Your final position is " + Arrays.toString(currentPosition));
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                field[i][j] = input[j].charAt(0);
            }
        }
    }

    private static int[] findStartPosition(int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 'P') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static void movePlayer(String command, int[] position, char[][] field, int size) {

        int row = position[0];
        int col = position[1];

        field[row][col] = '.';

        switch (command) {
            case "up":
                if (row > 0 && field[row - 1][col] == '#') {
                    stars--;
                    return;
                }
                position[0]--;
                break;
            case "down":
                if (row < size - 1 && field[row + 1][col] == '#') {
                    stars--;
                    return;
                }
                position[0]++;
                break;
            case "left":
                if (col > 0 && field[row][col - 1] == '#') {
                    stars--;
                    return;
                }
                position[1]--;
                break;
            case "right":
                if (col < size - 1 && field[row][col + 1] == '#') {
                    stars--;
                    return;
                }
                position[1]++;
                break;
        }
    }

    private static void handleBoundariesToOrigin(int[] position, int size) {
        for (int i = 0; i < 2; i++) {
            if (position[i] < 0 || position[i] >= size) {
                position[0] = 0;
                position[1] = 0;
                break;
            }
        }
    }


    private static void handleCurrentPosition(int[] position, char[][] field) {

        char currentChar = field[position[0]][position[1]];

        if (currentChar == '*') {
            stars++;
        }

        field[position[0]][position[1]] = 'P';
    }
}
