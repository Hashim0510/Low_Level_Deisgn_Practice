package Tictactoe.models;

import Tictactoe.models.enums.Playertype;

import java.util.Scanner;

public class Player {

    private String name;

    private long id;

    private Symbol symbol;

    private Playertype playerType;

    public Player(String name, long id, Symbol symbol, Playertype playerType) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Playertype getPlayerType() {
        return playerType;
    }

    public void setPlayerType(Playertype playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){

        //get the inputs of row and col from current player

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give the row value : ");

        int row = scanner.nextInt();

        System.out.println("Please give the col value : ");

        int col = scanner.nextInt();

        //create the Move object --->> Game class's responsibility to make the changes on tha board

        return new Move(new Cell(row, col), this);

    }
}
