package Tictactoe.startegies.winningStrategies;

import Tictactoe.models.Board;
import Tictactoe.models.Move;
import Tictactoe.models.Player;
import Tictactoe.models.Symbol;
import Tictactoe.models.enums.Playertype;

import java.util.HashMap;

public class DiagonalWinningStrategy implements winningStrategy{

    private HashMap<Symbol, Integer> leftDiagonalMap = new HashMap<>();
    private HashMap<Symbol, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {

        int row = move.getCell().getRow();

        int col = move.getCell().getCol();

        Symbol symbol = move.getPlayer().getSymbol();

        //check on leftDiagonalMap
        if(row == col){

            if(!leftDiagonalMap.containsKey(symbol)){
                leftDiagonalMap.put(symbol, 1);
            }
            else{

                leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) + 1);
            }


        }
        if(row + col == board.getSize() - 1){

            if(!rightDiagonalMap.containsKey(symbol)){
                rightDiagonalMap.put(symbol, 1);
            }
            else{

                rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) + 1);
            }
        }

//        if(leftDiagonalMap.get(symbol) == board.getSize() || rightDiagonalMap.get(symbol) == board.getSize()){
//
//            return true;
//
//        }

        if (row == col && leftDiagonalMap.get(symbol) == board.getSize()) {
            return true;
        }

        if (row + col == board.getSize() - 1 &&
                rightDiagonalMap.get(symbol) == board.getSize()) {
            return true;
        }

        return false;
    }

    @Override
    public void revertUndo(Player player, Move undoMove, Board board) {
        int row = undoMove.getCell().getRow();
        int col = undoMove.getCell().getCol();
        Symbol symbol = player.getSymbol();
        if(row == col){

            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) - 1);

        }
        else if(row + col == board.getSize() - 1){

            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) - 1);
        }

    }
}
