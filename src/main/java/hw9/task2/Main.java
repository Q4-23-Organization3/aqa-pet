package hw9.task2;

public class Main {
    public static void main(String[] args) {
        EngineeringCalculator EngineeringCalculator = new EngineeringCalculator();
        ProgrammableCalculator ProgrammableCalculator = new ProgrammableCalculator();
        System.out.println(EngineeringCalculator.division(5, 6));
        System.out.println(EngineeringCalculator.sin(180));
        System.out.println(ProgrammableCalculator.multiplication(3, 8));
        System.out.println(ProgrammableCalculator.whatKindOfProgrammistAmI("Awesome"));
    }
}
