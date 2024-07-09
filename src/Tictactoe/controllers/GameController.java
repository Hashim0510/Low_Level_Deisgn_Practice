package Tictactoe.controllers;

import Tictactoe.models.Move;
import Tictactoe.models.Player;
import Tictactoe.models.Game;
import Tictactoe.models.enums.GameStatus;
import Tictactoe.startegies.winningStrategies.winningStrategy;

import java.util.List;

public class GameController {


    public Game startGame(int size, List<Player> players, List<winningStrategy> winningStrategies){

        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }

    public void makeMove(Game game){
        game.makeMove(game.getBoard());
    }

    public Player getWinner(Game game){

        return game.getWinner();

    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void undo(Game game){

        game.undo();

    }

    public Player getCurrentplayer(Game game){

        System.out.println("player turn index : " + game.getCurrentPlayerTurn());
        return game.getPlayers().get(game.getCurrentPlayerTurn());

    }

    public void displayBoard(Game game){
        game.printBoard();
    }
}
