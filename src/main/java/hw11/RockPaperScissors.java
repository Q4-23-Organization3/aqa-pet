package hw11;


public class RockPaperScissors {
    private final Human user;
    private final Computer computer;
    private int userScore;
    private int computerScore;

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
            System.out.println(e.getMessage());
            return;
        }
        Move computerMove = computer.getMove();
        System.out.println("\nYour turn " + userMove + ".");
        System.out.println("Computers turn " + computerMove + ".\n");

        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
            case 0:
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
            System.out.println("Your statistic:");
            System.out.println("Wins=" + userScore);
            System.out.println("Loses=" + computerScore);
        }
    }
}