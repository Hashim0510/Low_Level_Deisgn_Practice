package Tictactoe.startegies.winningStrategies;

import Tictactoe.models.Board;
import Tictactoe.models.Move;
import Tictactoe.models.Player;

public interface winningStrategy {

    boolean checkWinner(Move move, Board board );
    void revertUndo(Player player, Move undoMove, Board board);
}
