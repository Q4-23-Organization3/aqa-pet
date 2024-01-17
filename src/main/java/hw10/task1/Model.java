package hw10.task1;

public class Model extends MobilePhone {
    String model;

    @Override
    public void printStatus() {
        super.printStatus();
    }

    @Override
    void printManufacturer() {
        System.out.println(manufacturer);
    }

    void printModel() {
        System.out.println(model);
    }
}
