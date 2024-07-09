package Tictactoe.startegies.PlayingStrategy;

import Tictactoe.models.Board;
import Tictactoe.models.Move;

public interface BotPlayingStrategy {

    Move makeNextMove(Board board);
}
