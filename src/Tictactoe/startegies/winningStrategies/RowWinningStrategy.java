package Tictactoe.startegies.winningStrategies;

import Tictactoe.models.Board;
import Tictactoe.models.Move;
import Tictactoe.models.Player;
import Tictactoe.models.Symbol;

import java.util.HashMap;

public class RowWinningStrategy implements winningStrategy{

    private HashMap<Integer, HashMap<Symbol, Integer>> rowMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
//        return null;
        int row = move.getCell().getRow();

        if(!rowMap.containsKey(row)){
            rowMap.put(row, new HashMap<>());
        }

        Symbol symbol = move.getPlayer().getSymbol();
        if(!rowMap.get(row).containsKey(symbol)){
            rowMap.get(row).put(symbol, 1);

        }
        else{
            rowMap.get(row).put(symbol, rowMap.get(row).get(symbol) + 1);

        }

        if(rowMap.get(row).get(symbol) == board.getSize()){

            return true;

        }
        return false;
    }

    @Override
    public void revertUndo(Player player, Move undoMove, Board board) {
        int row = undoMove.getCell().getRow();
        Symbol symbol = player.getSymbol();
        if(!rowMap.isEmpty()){
            rowMap.get(row).put(symbol, rowMap.get(row).get(symbol) - 1);
        }
    }
}
