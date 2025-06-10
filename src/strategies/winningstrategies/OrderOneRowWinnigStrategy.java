package strategies.winningstrategies;

import Models.Board;
import Models.Move;

public class OrderOneRowWinnigStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
