package hw11;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RockPaperScissors {
    private final Human user;
    private final Computer computer;
    private int userScore;
    private int computerScore;

    private final Logger logger = LogManager.getLogger(RockPaperScissors.class);

    public RockPaperScissors() {
        user = new Human();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
    }

    public void startGame() {
        System.out.println("ROCK, SCISSORS, PAPER!");

        Move userMove;
        // Обробка винятків
        try {
            userMove = user.getMove();
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return;
        }
        Move computerMove = computer.getMove();
        System.out.println("\nYour turn " + userMove + ".");
        System.out.println("Computers turn " + computerMove + ".\n");

        int compareMoves = userMove.compareMoves(computerMove);
        logger.debug("Comparing result: " + compareMoves);
        switch (compareMoves) {
            case 0:
                logger.debug("Comparing result: " + compareMoves);
                System.out.println("Tie!");
                break;
            case 1:
                System.out.println(userMove + " beats " + computerMove + ". You WIN!");
                userScore++;
                break;
            case -1:
                System.out.println(computerMove + " beats " + userMove + ". You LOSE.");
                computerScore++;
                break;
        }

        if (user.playAgain()) {
            System.out.println();
            startGame();
        } else {
            System.out.println("Your statistic: \nWins=" + userScore + "\nLoses=" + computerScore);
        }
    }
}