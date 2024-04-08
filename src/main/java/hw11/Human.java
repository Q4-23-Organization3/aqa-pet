package hw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Human extends AbstractPlayer {

    private final Logger logger = LogManager.getLogger(Human.class);
    private final Scanner inputScanner;

    public Human() {
        logger.info("Create Human");
        inputScanner = new Scanner(System.in);
    }

    @Override
    public Move getMove() {
        System.out.print("Rock, Scissors or Paper? ");

        // Інтерактивність - команди задаються з консолі
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        char firstLetter = userInput.charAt(0);
        logger.info("User input " + userInput);
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
            logger.error("Incorrect input");
            throw new IllegalArgumentException("Try to use Rock, Scissors or Paper next time. Bye!");
        }

        return null;
    }

    public boolean playAgain() {
        System.out.print("One more try? ");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        logger.info("User input " + userInput);
        return userInput.charAt(0) == 'Y';
    }
}
