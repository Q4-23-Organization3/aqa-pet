package hw9.task1;

import java.util.Objects;

public class Triangle extends Shape {
    private double x1 = 0;
    private double y1 = 0;
    private double x2 = 3;
    private double y2 = 3;
    private double x3 = 6;
    private double y3 = 0;

    private double sideA = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    private double sideB = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
    private double sideC = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));

    @Override
    public double calculateArea() {
        double semiperimeter = calculatePerimeter() / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - sideA) * (semiperimeter - sideB) * (semiperimeter - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return (sideA + sideB + sideC);
    }

    @Override
    public void paint(String color) {
        super.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle triangle)) return false;
        return Double.compare(triangle.x1, x1) == 0 && Double.compare(triangle.y1, y1) == 0 && Double.compare(triangle.x2, x2) == 0 && Double.compare(triangle.y2, y2) == 0 && Double.compare(triangle.x3, x3) == 0 && Double.compare(triangle.y3, y3) == 0 && Double.compare(triangle.sideA, sideA) == 0 && Double.compare(triangle.sideB, sideB) == 0 && Double.compare(triangle.sideC, sideC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, x3, y3, sideA, sideB, sideC);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                ", sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", color='" + color + '\'' +
                '}';
    }
}
