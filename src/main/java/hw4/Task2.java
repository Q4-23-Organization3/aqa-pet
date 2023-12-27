package hw4;

public class Task2 {
    public static void main(String[] args) {
        double celsius = 501;
        double fahrenheit = (celsius / ((double) 5 / 9)) + 32;
        double kelvin = celsius + 273.16;
        System.out.println(celsius + " Celsius: " + fahrenheit + " Fahrenheit; " + kelvin + " Kelvin");
    }
}
