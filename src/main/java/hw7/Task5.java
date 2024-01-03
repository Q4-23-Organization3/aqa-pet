package hw7;

import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        int firstArraySize = 5;
        int secondArraySize = 5;
        int[][] matrix = new int[firstArraySize][secondArraySize];
        Random random = new Random();

        for (int i = 0; i < firstArraySize; i++) {
            for (int j = 0; j < secondArraySize; j++) {
                matrix[i][j] = random.nextInt(10 + 10) - 10;
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
        int countElementsBelowZero = 0;
        int sumOddElements = 0;
        for (int i = 0; i < firstArraySize; i++) {
            for (int j = 0; j < secondArraySize; j++) {
                if (i > j && matrix[i][j] < 0) {
                    countElementsBelowZero++;
                }
                if (i < j && matrix[i][j] % 2 != 0) {
                    sumOddElements += matrix[i][j];
                }
            }
        }
        System.out.println("Count elements below zero: " + countElementsBelowZero);
        System.out.println("Sum of even elements: " + sumOddElements);
    }
}
