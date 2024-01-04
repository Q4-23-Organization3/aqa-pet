package hw7;


public class Task4 {
    public static void main(String[] args) {
        double[] sinus = new double[37];
        for (int i = 0; i <= 360; i = i + 10) {
            sinus[i / 10] = Math.sin(Math.toRadians(i));
        }
        for (int i = 0; i <= sinus.length - 1; i++) {
            System.out.format("Sinus " + i * 10 + " = %.4f\n", sinus[i]);
        }
    }
}
