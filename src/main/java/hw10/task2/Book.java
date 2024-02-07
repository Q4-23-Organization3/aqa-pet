package hw10.task2;

import java.util.function.Consumer;

public class Book implements Printable {
    private final String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public void print(Consumer<String> consumer) {
        consumer.accept("I am book");
    }

    public static void printBooks(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Book) {
                System.out.println(((Book) p).name);
            }
        }
    }
}
