package hw10.task1;

public interface Mobile {

    default void printStatus() {
        System.out.println("I am related to Mobile");
    }
}
