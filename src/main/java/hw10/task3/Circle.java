package hw10.task3;

import java.util.Objects;

public class Circle extends Shape {
    private double x = 0;
    private double y = 0;
    private double rad = 5;

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(rad, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * rad;
    }

    @Override
    public void paint(String color) {
        super.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle circle)) return false;
        return Double.compare(circle.x, x) == 0 && Double.compare(circle.y, y) == 0 && Double.compare(circle.rad, rad) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, rad);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", rad=" + rad +
                ", color='" + color + '\'' +
                '}';
    }
}
