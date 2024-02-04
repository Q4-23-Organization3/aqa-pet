package hw12;

//Є List зі словами. Виділити всі унікальні слова.
// Для кожного слова підрахувати частоту його входження в текст.
// Слова, які відрізняються регістром літер, вважати різними.
// Використовувати клас HashMap.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UniqueWords {

    private final static String sentence = "Some sequence for test about " +
            "Java, Python or python, maybe Ruby and JavaScript but you should know that " +
            "Java is not the same as JavaScript";
    public static void main(String[] args) {
        // Split sentence to ArrayList with removing punctuation symbols
        String[] rawWords = sentence.replaceAll(",", "").split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(rawWords));
        // Creating HashMap
        HashMap<String, Integer> uniqueWords = new HashMap<>();
        // Counting words
        for (String word : list) {
            int count = 1;
            if (uniqueWords.containsKey(word)) {
                count = uniqueWords.get(word) + 1;
            }
            uniqueWords.put(word, count);
        }
        // Print words count
        for (String word : uniqueWords.keySet()) {
            System.out.println("Word " + word + " appears " + uniqueWords.get(word) + " times");
        }
    }
}
