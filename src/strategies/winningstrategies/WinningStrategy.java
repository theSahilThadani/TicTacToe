package strategies.winningstrategies;

import Models.Board;
import Models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
}
