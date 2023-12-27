package hw6;

import java.util.Scanner;

public class PrintMonthInWordCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter month number:");
        int monthNumber = scanner.nextInt();
        switch (monthNumber) {
            case (1) -> System.out.println("JAN");
            case (2) -> System.out.println("FEB");
            case (3) -> System.out.println("MAR");
            case (4) -> System.out.println("APR");
            case (5) -> System.out.println("MAY");
            case (6) -> System.out.println("JUN");
            case (7) -> System.out.println("JUL");
            case (8) -> System.out.println("AUG");
            case (9) -> System.out.println("SEP");
            case (10) -> System.out.println("OCT");
            case (11) -> System.out.println("NOV");
            case (12) -> System.out.println("DEC");
            default -> System.out.println("Not a valid month");
        }
    }
}
