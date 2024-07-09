package Tictactoe.startegies.winningStrategies;

import Tictactoe.models.Board;
import Tictactoe.models.Move;
import Tictactoe.models.Player;
import Tictactoe.models.Symbol;

import java.util.HashMap;

public class ColumnWinningStrategy implements winningStrategy{

    private HashMap<Integer, HashMap<Symbol, Integer>> colMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();

        if(!colMap.containsKey(col)){
            colMap.put(col, new HashMap<>());
        }


        Symbol symbol = move.getPlayer().getSymbol();
        if(!colMap.get(col).containsKey(symbol)){
            colMap.get(col).put(symbol, 1);

        }
        else{
            colMap.get(col).put(symbol, colMap.get(col).get(symbol) + 1);

        }

        if(colMap.get(col).get(symbol) == board.getSize()){

            return true;

        }
        return false;
    }

    @Override
    public void revertUndo(Player player, Move undoMove, Board board) {

        int col = undoMove.getCell().getCol();
        Symbol symbol = player.getSymbol();
        if(!colMap.isEmpty()){
            colMap.get(col).put(symbol, colMap.get(col).get(symbol) - 1);
        }


    }


}
