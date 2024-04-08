package hw11;

import org.apache.logging.log4j.Level;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoggerConfig config = new LoggerConfig();
        config.createConfig(selectLogLevel());
        RockPaperScissors game = new RockPaperScissors();
        game.startGame();
    }

    public static Level selectLogLevel() {
        Level level = Level.ALL;
        System.out.println("Select log level:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        try {
            Level choosedLevel = Level.getLevel(userInput);
            if (choosedLevel != null) {
                level = choosedLevel;
            } else {
                throw new IllegalArgumentException("");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect input, selected log level " + level.name());
        }
        return level;
    }
}
