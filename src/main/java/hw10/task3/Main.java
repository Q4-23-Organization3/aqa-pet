package hw10.task3;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Triangle();

        for (Shape shape : shapes) {
            System.out.println("Area = " + shape.calculateArea() + " cm2.");
            System.out.println("Perimeter = " + shape.calculatePerimeter() + " cm.");
            shape.paint("pink");
            System.out.println("Color = " + shape.color);
        }

        System.out.println(shapes[0].equals(shapes[0]));
        System.out.println(shapes[1].hashCode());
        System.out.println(shapes[2]);
    }
}

