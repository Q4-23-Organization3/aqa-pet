package hw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Computer extends AbstractPlayer {

    private final Logger logger = LogManager.getLogger(Computer.class);

    @Override
    public Move getMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        logger.debug("Computers choice: " + moves[index]);
        return moves[index];
    }
}

