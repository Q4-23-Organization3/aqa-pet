package hw7;

public class Task2 {
    public static void main(String[] args) {
        int[] arrayForCompare = {300, 134, 2, 0, -157, 4, 10};
        int max = arrayForCompare[0];
        int min = arrayForCompare[0];
        for (int i = 1; i < arrayForCompare.length; i++) {
            if (arrayForCompare[i] > max) {
                max = arrayForCompare[i];
            }
            if (arrayForCompare[i] < min) {
                min = arrayForCompare[i];
            }
        }
        System.out.println("Maximum value is " + max);
        System.out.println("Minimun value is " + min);
    }
}
