package _ExamPreparation_02_.Task_02_;

import java.util.Scanner;

public class Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int energy = 15;
        boolean isHiveReached = false;
        boolean isRestored = false;
        int nectar = 0;
        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];

        //fill matrix and get 'B' coordinates
        int[] coordinates = new int[2];

        coordinates = fillMatrix(scanner, n, field);

        while (!isHiveReached){
            
            if (energy <= 0){
                break;
            }
            
           String command = scanner.nextLine();

            move(command, coordinates);
            field[coordinates[0]][coordinates[1]] = '-';

            // check if out of bounds and move the Bee to the opposite side
            moveToOppositeSideIfNeeded(coordinates, n);

            char currentSymbol = field[coordinates[0]][coordinates[1]];

            // check for digit, 'H' or '-'
            if (currentSymbol == 'H'){
                isHiveReached = true;
            } else{
                nectar += Character.isDigit(currentSymbol) ?
                        Character.getNumericValue(currentSymbol) :
                        0;
            }
            energy--;

            // restore energy if needed
            if (!isRestored){
                if (energy <= 0 && nectar > 30){
                    int restValue = nectar - 30;
                    energy += restValue;
                    nectar -= restValue;
                    isRestored = true;
                }
            }

            field[coordinates[0]][coordinates[1]] = 'B';
        }

        if (isHiveReached){
            if (nectar >= 30){
                System.out.printf("Great job, Beesy! The hive is full. Energy left: %d\n"
                        , energy);
            } else {
                System.out.println("Beesy did not manage to collect enough nectar.");
            }
        } else {
            System.out.println("This is the end! Beesy ran out of energy.");
        }

        printMatrix(field);
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

    private static void move(String command, int[] coordinates) {
        switch (command) {
            case "up" ->
                    coordinates[0]--;
            case "down" ->
                    coordinates[0]++;
            case "left" ->
                    coordinates[1]--;
            case "right" ->
                    coordinates[1]++;
        }
    }

    private static void printMatrix(char[][] field) {
        for (char[] row : field){
            System.out.println(row);
        }
    }

    private static int[] fillMatrix(Scanner scanner, int n, char[][] field) {
        int[] coordinates = new int[2];
        for (int r = 0; r < n; r++) {
            field[r] = scanner.nextLine().toCharArray();
            //search for 'B' coordinates
            for (int c = 0; c < n; c++) {
                if (field[r][c] == 'B'){
                    coordinates[0] = r;
                    coordinates[1] = c;
                    break;
                }
            }
        }
        return coordinates;
    }
}
