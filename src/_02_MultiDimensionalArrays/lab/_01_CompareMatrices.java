package _02_MultiDimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int firstRows = input[0];

        int [] [] firstMatrix = new int[firstRows][];
        for (int i = 0; i < firstRows; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            firstMatrix[i] = arr;
        }

       input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int secondRows = input[0];

        int[][] secondMatrix = new int[secondRows][];
        for (int i = 0; i < secondRows; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = arr;
        }

        if (matricesAreEqual(firstMatrix,secondMatrix)){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length){
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
