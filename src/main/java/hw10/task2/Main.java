package hw10.task2;

public class Main {
    public static void main(String[] args) {
        Printable[] printables = new Printable[4];
        printables[0] = new Book("How to Stop Worrying and Start Living");
        printables[1] = new Book("Java. Beginner's Guide");
        printables[2] = new Magazine("TIME");
        printables[3] = new Magazine("ELLE");

        for (Printable printable : printables) {
            printable.print();
        }
        Magazine.printMagazines(printables);
        Book.printBooks(printables);
    }
}
