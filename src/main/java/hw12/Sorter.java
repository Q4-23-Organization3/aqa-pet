package hw12;
//Задано список цілих чисел та число X.
// Не використовуючи допоміжних об'єктів і не змінюючи розмір списку,
// переставити елементи списку так,щоб спочатку йшли числа,
// що не перевищують X, а потім числа, більші за X.

import java.util.*;

public class Sorter {
    public static void main(String[] args) {
        // Creating the ArrayList
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int j = random.nextInt(20);
            list.add(j);
        }
        // Printing the ArrayList
        System.out.println(list);
        // Entering number
        System.out.println("Enter X:");
        Scanner scanner = new Scanner(System.in);
        Integer x = scanner.nextInt();
        // Sorting ArrayList
        list.sort(new NumberComparator(x));
        // Printing sorted ArrayList
        System.out.println(list);
    }

}
