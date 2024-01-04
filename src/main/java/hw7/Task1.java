package hw7;


public class Task1 {
    public static void main(String[] args) {
        String initialWord = "Шалаш";
        char[] string = initialWord.toCharArray();
        char[] reversedString = new char[string.length];
        for (int i = 0; i <= string.length - 1; i++) {
            reversedString[i] = string[string.length - 1 - i];
        }
        if (initialWord.equalsIgnoreCase(String.valueOf(reversedString))) {
            System.out.println(initialWord + " is a palindrome");
        } else {
            System.out.println(initialWord + " is not a palindrome");
        }
    }
}