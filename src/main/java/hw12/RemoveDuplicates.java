package hw12;

//1.Написати програму яка видаляє з колекції цілих чисел всі дублікати, якщо вони є.
// Початкову колекцію з 100 елементів потрібно заповнити випадковими числами (діапазон -20 20).
// На екран потрібно вивести обидві колекції та кількість видалених дублікатів.

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicates {
    public static void main(String args[]) {
        // Creating the ArrayList with duplicates
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            int j = random.nextInt(20 + 20) - 20;
            list.add(j);
        }
        // Print the Arraylist with duplicates
        System.out.println("ArrayList with duplicates: " + list);
        // Remove duplicates
        ArrayList<Integer> newList = removeDuplicates(list);
        // Print the ArrayList without duplicates
        System.out.println("ArrayList without duplicates: " + newList);
        // Print Removed elements amount
        System.out.println("Number of removed duplicates: " + (list.size() - newList.size()));
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        // Create a new ArrayList
        ArrayList<Integer> newList = new ArrayList<Integer>();
        // Traverse through the first list
        for (Integer element : list) {
            // If this element is not present in newList then add it
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        // return the new list
        return newList;
    }


}
