package hw11;

import java.util.Random;

public class Computer extends AbstractPlayer {
    @Override
    public Move getMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }
}

