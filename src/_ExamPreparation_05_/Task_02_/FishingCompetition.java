package _ExamPreparation_05_.Task_02_;

import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];

        fillMatrix(scanner, n, field);
        int totalAmount = 0;
        int[] currentPosition = findStartPosition(n, field);

        String command = scanner.nextLine();
        while (!command.equals("collect the nets")){

            movePlayer(command, currentPosition, field);
            moveToOppositeSideIfNeeded(currentPosition, n);

            char currentSymbol = field[currentPosition[0]][currentPosition[1]];

            if (currentSymbol == 'W'){
                System.out.println("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: ["
                + currentPosition[0] + "," + currentPosition[1] + "]");
                return;
            } else {
                totalAmount += Character.isDigit(currentSymbol) ?
                        Character.getNumericValue(currentSymbol) :
                        0;
            }

            command = scanner.nextLine();
        }
        if (totalAmount >= 20){
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.println("You didn't catch enough fish and didn't reach the quota! You need " + (20 - totalAmount) + " tons of fish more.");
        }
        if (totalAmount > 0){
            System.out.println("Amount of fish caught: " + totalAmount + " tons.");
        }
        field[currentPosition[0]][currentPosition[1]] = 'S';
        printMatrix(field);


    }
    private static void printMatrix(char[][] field) {
        for (char[] row : field){
            System.out.println(row);
        }
    }
    private static void moveToOppositeSideIfNeeded(int[] coordinates, int n) {
        // check if out of bounds and move the Bee to the opposite side
        int row = coordinates[0];
        int col = coordinates[1];

        if (row < 0){
            coordinates[0] = n - 1;
        } else if (row >= n){
            coordinates[0] = 0;
        }

        if (col < 0){
            coordinates[1] = n - 1;
        } else if (col >= n){
            coordinates[1] = 0;
        }
    }
    private static void fillMatrix(Scanner scanner, int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }
    }
    private static int[] findStartPosition(int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 'S') {
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
}
