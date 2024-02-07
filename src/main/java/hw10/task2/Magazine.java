package hw10.task2;

import java.util.function.Consumer;

public class Magazine implements Printable {
    private final String name;

    public Magazine(String name) {
        this.name = name;
    }

    @Override
    public void print(Consumer<String> consumer) {
        consumer.accept("I am Magazine");
    }

    public static void printMagazines(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Magazine) {
                System.out.println(((Magazine) p).name);
            }
        }
    }
}
