package hw6;

import java.util.Scanner;

public class CompareNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first number:");
        int firstNumber = scanner.nextInt();
        System.out.println("Please enter second number:");
        int secondNumber = scanner.nextInt();
        if (Math.abs(firstNumber) > Math.abs(secondNumber)) {
            System.out.println("Module of " + firstNumber + " is bigger then module of " + secondNumber);
        } else {
            System.out.println("Module of " + secondNumber + " is bigger then module of " + firstNumber);
        }
    }
}
