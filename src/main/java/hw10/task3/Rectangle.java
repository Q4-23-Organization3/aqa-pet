package hw10.task3;

import java.util.Objects;

public class Rectangle extends Shape {
    private double x1 = 0;
    private double y1 = 0;
    private double x2 = 3;
    private double y2 = 3;

    private double sideA = (x2 - x1);
    private double sideB = (y2 - y1);

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (sideA + sideB);
    }

    @Override
    public void paint(String color) {
        super.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return Double.compare(rectangle.x1, x1) == 0 &&
                Double.compare(rectangle.y1, y1) == 0 &&
                Double.compare(rectangle.x2, x2) == 0 &&
                Double.compare(rectangle.y2, y2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", color='" + color + '\'' +
                '}';
    }
}
