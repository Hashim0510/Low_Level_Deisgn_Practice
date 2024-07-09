package Tictactoe.models;

import Tictactoe.models.enums.BotDifficultyLevel;
import Tictactoe.models.enums.Playertype;
import Tictactoe.startegies.PlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, long id, Symbol symbol, Playertype playerType, BotDifficultyLevel botDifficultyLevel, BotPlayingStrategy botPlayingStrategy) {
        super(name, id, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public Move makeMove(Board board){

        Move move = this.botPlayingStrategy.makeNextMove(board);
        move.setPlayer(this);
        return move;

    }



}
