package Tictactoe;

import Tictactoe.controllers.GameController;
import Tictactoe.models.Bot;
import Tictactoe.models.Game;
import Tictactoe.models.Player;
import Tictactoe.models.Symbol;
import Tictactoe.models.enums.BotDifficultyLevel;
import Tictactoe.models.enums.GameStatus;
import Tictactoe.models.enums.Playertype;
import Tictactoe.startegies.PlayingStrategy.EasyBotPlayingStrategy;
import Tictactoe.startegies.winningStrategies.ColumnWinningStrategy;
import Tictactoe.startegies.winningStrategies.DiagonalWinningStrategy;
import Tictactoe.startegies.winningStrategies.RowWinningStrategy;
import Tictactoe.startegies.winningStrategies.winningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain{

    public static void main(String[] args) {


                                    //********IMPORTANT ********/

        /*

        UNDO SHOULD HAVE TO BE COMPLETELY IMPLEMENTED ---->>> NEED TO MAKE SURE CHECKWINNER
        HASHMAP'S ARE PROPERLY REVERTING THE PAST MOVES

         */

        //initiate gamecontroller
        GameController gameController = new GameController();

        //initiate game by giving inputs from client

        int size = 3;
        int numberOfPlayers =  size - 1;
        List<Player> players = new ArrayList<>();

        players.add(new Player("Hashim", 2, new Symbol('X'), Playertype.HUMAN));
        players.add(new Bot("Bot", 1, new Symbol('O'),
                Playertype.BOT, BotDifficultyLevel.EASY, new EasyBotPlayingStrategy()));

        List<winningStrategy> winningStrategies = new ArrayList<>();

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());
        Game game = gameController.startGame(size, players, winningStrategies);


        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){

            System.out.println("THIS IS THE CURRENT STATE OF BOARD !!!");
            gameController.displayBoard(game);

            System.out.println("THIS IS " + gameController.getCurrentplayer(game).getName() + "'s move");

            System.out.println("get current index : " + game.getCurrentPlayerTurn());
            if(!gameController.getCurrentplayer(game).getPlayerType().equals(Playertype.BOT)) {

                //make player to move
                System.out.println("Choose the below options :");
                System.out.println("1. Make a move");
                System.out.println("2. Undo the last Move");
                Scanner scanner = new Scanner(System.in);
                System.out.print("give the input operation you want :");
                int operationInput = scanner.nextInt();

                switch (operationInput) {

                    case 1:
                        gameController.makeMove(game);
                        break;
                    case 2:
                        gameController.undo(game);
                        break;

                }

                System.out.println("get current index after making a move : " + game.getCurrentPlayerTurn());


            }else{

                gameController.makeMove(game);

            }
//            gameController.makeMove(game);

        }

        if(gameController.getGameStatus(game).equals(GameStatus.ENDED)){
            gameController.displayBoard(game);
            System.out.println(gameController.getWinner(game).getName() + " is the winner!!!");
        }
        else if(gameController.getGameStatus(game).equals(GameStatus.DRAW)){
            System.out.println("GAME HAS DRAWN !!!");
        }



    }
}