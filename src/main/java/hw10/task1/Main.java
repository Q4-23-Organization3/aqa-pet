package hw10.task1;

public class Main {
    public static void main(String[] args) {
        Model model1 = new Model();
        model1.model = "Iphone 15 Pro Max Black";
        model1.manufacturer = "Apple";

        model1.printManufacturer();
        model1.printModel();
        model1.printStatus();
    }
}
