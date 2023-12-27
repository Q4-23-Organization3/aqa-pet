package hw6;

import java.util.Scanner;

public class PrintMonthInWordIfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter month number:");
        int monthNumber = scanner.nextInt();
        if (monthNumber == 1) {
            System.out.println("JAN");
        } else {
            if (monthNumber == 2) {
                System.out.println("FEB");
            } else {
                if (monthNumber == 3) {
                    System.out.println("MAR");
                } else {
                    if (monthNumber == 4) {
                        System.out.println("APR");
                    } else {
                        if (monthNumber == 5) {
                            System.out.println("MAY");
                        } else {
                            if (monthNumber == 6) {
                                System.out.println("JUN");
                            } else {
                                if (monthNumber == 7) {
                                    System.out.println("JUL");
                                } else {
                                    if (monthNumber == 8) {
                                        System.out.println("AUG");
                                    } else {
                                        if (monthNumber == 9) {
                                            System.out.println("SEP");
                                        } else {
                                            if (monthNumber == 10) {
                                                System.out.println("OCT");
                                            } else {
                                                if (monthNumber == 11) {
                                                    System.out.println("NOV");
                                                } else {
                                                    if (monthNumber == 12) {
                                                        System.out.println("DEC");
                                                    } else {
                                                        System.out.println("Not a valid month");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
