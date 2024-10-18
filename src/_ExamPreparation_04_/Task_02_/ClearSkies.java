package _ExamPreparation_04_.Task_02_;

import java.util.Scanner;

public class ClearSkies {
    private static int countEnemies = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];
        int armour = 300;
        fillMatrix(scanner, n, field);

        int[] currentPosition = findStartPosition(n, field);
        countEnemies(n, field);
        while (true) {
            String command = scanner.nextLine();

            movePlayer(command, currentPosition, field);
            if (field[currentPosition[0]][currentPosition[1]] == 'E') {
                field[currentPosition[0]][currentPosition[1]] = '-';
                armour -= 100;
                countEnemies--;
            } else if (field[currentPosition[0]][currentPosition[1]] == 'R') {
                field[currentPosition[0]][currentPosition[1]] = '-';
                if (armour < 300) {
                    armour = 300;
                }
            }
            if (armour == 0) {
                field[currentPosition[0]][currentPosition[1]] = 'J';
                System.out.println("Mission failed, your jetfighter was shot down! Last coordinates ["
                        + currentPosition[0] + ", " + currentPosition[1] + "]!");
                printMatrix(field);
                break;
            } else if (countEnemies == 0){
                field[currentPosition[0]][currentPosition[1]] = 'J';
                System.out.println("Mission accomplished, you neutralized the aerial threat!");
                printMatrix(field);
                break;
            }
        }
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }
    }
    private static void countEnemies(int size, char[][]field){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 'E') {
                    countEnemies++;
                }
            }
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

    private static void movePlayer(String command, int[] position, char[][] field) {

        int row = position[0];
        int col = position[1];

        field[row][col] = '-';

        switch (command) {
            case "up":
                position[0]--;
                break;
            case "down":
                position[0]++;
                break;
            case "left":
                position[1]--;
                break;
            case "right":
                position[1]++;
                break;
        }
    }
    private static void printMatrix(char[][] field) {
        for (char[] row : field){
            System.out.println(row);
        }
    }
}
