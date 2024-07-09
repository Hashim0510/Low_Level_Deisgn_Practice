package Tictactoe.startegies.PlayingStrategy;

import Tictactoe.models.Board;
import Tictactoe.models.Cell;
import Tictactoe.models.Move;
import Tictactoe.models.enums.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeNextMove(Board board) {
//        return null;
        //bot will make a move on the next available empty cell in the board

        for(List<Cell> row : board.getPlayingBoard()){

            for(Cell cell : row){

                if(cell.getCellState().equals(CellState.EMPTY)){

                    return new Move(cell, null);

                }
            }
        }
        return null;
    }

}
