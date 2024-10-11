package _ExamPreparation_01_.Task_02_;

import java.util.Scanner;

public class EscapeTheMaze {
   private static int n;
   private static String[][] maze;
   private static int health = 100;
   private static int startRow = -1;
   private static int startCol = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());

        maze = new String[n][n];


        for (int rows = 0; rows < n; rows++) {
            String input = scanner.nextLine();
            for (int cols = 0; cols < n; cols++) {
                char c = input.charAt(cols);
                maze[rows][cols] = String.valueOf(c);
                if (String.valueOf(c).equals("P")){
                    startRow = rows;
                    startCol = cols;
                    maze[startRow][startCol] = "-";
                }

            }
        }
        String command = scanner.nextLine();
        while (true) {

            move(command);

            if (maze[startRow][startCol].equals("X")){
                maze[startRow][startCol] = "P";
                System.out.println("Player escaped the maze. Danger passed!");
                System.out.println("Player's health: " + health + " units");
                for (int rows = 0; rows < n; rows++) {
                    for (int cols = 0; cols < n; cols++) {
                        System.out.print(maze[rows][cols]);
                    }
                    System.out.println();
                }
                return;
            }

            if (health <= 0){
                maze[startRow][startCol] = "P";
                health = 0;
                System.out.println("Player is dead. Maze over!");
                System.out.println("Player's health: " + health + " units");
                for (int rows = 0; rows < n; rows++) {
                    for (int cols = 0; cols < n; cols++) {
                        System.out.print(maze[rows][cols]);
                    }
                    System.out.println();
                }
                return;
            }
            command = scanner.nextLine();
        }
    }

    private static void move(String direction){
        int newRow = startRow;
        int newCol = startCol;

        switch (direction){
            case "up":
                newRow = startRow - 1;
                break;
            case "down":
                newRow = startRow + 1;
                break;
            case "right":
                newCol = startCol + 1;
                break;
            case "left":
                newCol = startCol - 1;
                break;
        }
        if (isInBounds(newRow,newCol)){
            startRow = newRow;
            startCol = newCol;

            if (maze[startRow][startCol].equals("M")){
                health -= 40;
                if (health > 0){
                    maze[startRow][startCol] = "-";
                }
            } else if (maze[startRow][startCol].equals("H")){
                health += 15;
                if (health > 100){
                    health = 100;
                }
                maze[startRow][startCol] = "-";
            }
        }
    }

    private static boolean isInBounds(int newRow, int newCol){
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < n;
    }
}


