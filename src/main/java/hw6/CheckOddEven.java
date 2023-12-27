package hw6;

import java.util.Scanner;

public class CheckOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number to check if it is even or odd:");
        int numberOne = scanner.nextInt();
        if (numberOne % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
        System.out.println("BYE");
    }
}
