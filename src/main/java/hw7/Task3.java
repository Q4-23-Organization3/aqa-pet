package hw7;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int length = 10;
        int[] nums = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println("Initial array: " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            }
        }
        System.out.println("New array: " + Arrays.toString(nums));
    }
}
