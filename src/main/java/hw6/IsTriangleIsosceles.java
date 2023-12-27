package hw6;

public class IsTriangleIsosceles {
    public static void main(String[] args) {
        double a = 5;
        double b = 18;
        double c = 5;
        if (a == b | a == c | b == c) {
            System.out.println("Triangle is isosceles");
        } else System.out.println("Triangle is not isosceles");
    }
}
