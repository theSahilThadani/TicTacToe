package strategies.winningstrategies;

import Models.Board;
import Models.Move;

public class OrderOneColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
