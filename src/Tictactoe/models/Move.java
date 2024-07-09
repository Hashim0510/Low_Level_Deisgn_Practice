package Tictactoe.models;


import Tictactoe.models.enums.Playertype;

//Move class is used to record the move the move of the player and at which cell is making their move
public class Move {

    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player){

        this.cell = cell;
        this.player = player;

    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
