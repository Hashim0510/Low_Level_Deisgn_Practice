package Tictactoe.models;

import Tictactoe.models.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> playingBoard;
    private int size;

    public Board(int size){
        this.size = size;
        this.playingBoard = new ArrayList<>();

        for(int i = 0; i < this.size; i++){

            this.playingBoard.add(new ArrayList<>());

            for(int j = 0; j < this.size; j++) {

                this.playingBoard.get(i).add(new Cell(i, j));

            }

        }
    }

    public List<List<Cell>> getPlayingBoard() {
        return playingBoard;
    }

    public void setPlayingBoard(List<List<Cell>> playingBoard) {
        this.playingBoard = playingBoard;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void printBoard(){

        for(int i = 0; i < this.size; i++){

            for(int j = 0; j < this.size; j++){

                Cell cell = this.playingBoard.get(i).get(j);

                if(cell.getCellState().equals(CellState.EMPTY)){
                    System.out.print(" |   | ");

                }
                else{

                    System.out.print(" | " + cell.getPlayer().getSymbol().getSymbol() + " | ");
                }
            }

            System.out.println();

        }
    }
}
