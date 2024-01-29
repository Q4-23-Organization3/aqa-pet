package hw11;

import java.util.Scanner;

public class Human extends AbstractPlayer {

    private final Scanner inputScanner;

    public Human() {
        inputScanner = new Scanner(System.in);
    }

    @Override
    public Move getMove() {
        System.out.print("Rock, Scissors or Paper? ");

        // Інтерактивність - команди задаються з консолі
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        char firstLetter = userInput.charAt(0);
        if (firstLetter == 'R' || firstLetter == 'P' || firstLetter == 'S') {
            switch (firstLetter) {
                case 'R':
                    return Move.ROCK;
                case 'P':
                    return Move.PAPER;
                case 'S':
                    return Move.SCISSORS;
            }
        } else {
            throw new IllegalArgumentException("Try to use Rock, Scissors or Paper next time. Bye!");
        }

        return null;
    }

    public boolean playAgain() {
        System.out.print("One more try? ");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
    }
}
