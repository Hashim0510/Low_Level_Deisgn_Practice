package Tictactoe.models;
import Tictactoe.models.enums.CellState;
import Tictactoe.models.enums.GameStatus;
import Tictactoe.startegies.winningStrategies.winningStrategy;

import java.util.*;

public class Game {

    private Board board;
    private List<Player> players;
    private int currentPlayerTurnIndex;
    private List<Move> Moves;
    private Player winner;
    private GameStatus gameStatus;
    private List<winningStrategy> winningStrategies;

    //use builder dp for Game class

    public Game(int size, List<Player> players, List<winningStrategy> winningStrategies){

        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(size);
        this.currentPlayerTurnIndex = 0;
        this.Moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;

    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayerTurn() {
        return currentPlayerTurnIndex;
    }

    public void setCurrentPlayerTurn(int currentPlayerTurnIndex) {
        this.currentPlayerTurnIndex = currentPlayerTurnIndex;
    }

    public List<Move> getMoves() {
        return Moves;
    }

    public void setMoves(List<Move> moves) {
        Moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public static class GameBuilder{

        private List<Player> players;
        private List<winningStrategy> winningStrategies;
        private int size;


        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStrategies(List<winningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public GameBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        public Game build(){

            return new Game(this.size, this.players, this.winningStrategies);
        }
    }

    public void printBoard(){

        board.printBoard();
    }

    public boolean checkWinner(Move move, Board board){

        for(winningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(move, board)){
                return true;
            }
        }

        return false;
    }

    private boolean validateMove(Move move, Board board){

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row >= board.getSize() || col >= board.getSize() || row < 0 || col < 0
                || board.getPlayingBoard().get(row).get(col).getCellState().equals(CellState.OCCUPIED)){

            return false;

        }

        return true;

    }

    public void makeMove(Board board){

        Player currentplayer = players.get(currentPlayerTurnIndex);

        //get the player's move
        Move currentMove = currentplayer.makeMove(board);

        //validate the move
        if(!validateMove(currentMove, board)){
            System.out.println("invalid move.");
            return;
        }

        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();
        Cell validCell = board.getPlayingBoard().get(row).get(col);
        validCell.setPlayer(currentplayer);
        validCell.setCellState(CellState.OCCUPIED);
        Move finalMove = new Move(validCell, currentplayer);
        this.Moves.add(finalMove);

        if(checkWinner(finalMove, board)){

            setGameStatus(GameStatus.ENDED);
            setWinner(currentplayer);

        }
        else if(this.Moves.size() == board.getSize()*board.getSize()){

//            System.out.println("GAME IS DRAWN");
            setGameStatus(GameStatus.DRAW);

        }


        this.currentPlayerTurnIndex += 1;
        this.currentPlayerTurnIndex %= players.size();
        setCurrentPlayerTurn(this.currentPlayerTurnIndex);
        System.out.println("current player after making move :" + getCurrentPlayerTurn());

//        return currentMove;

    }

    public void revertCheckWinnerMapsForUndo(Player player, Move undoMove, Board board){

        for(winningStrategy winningStrategy: winningStrategies){
            winningStrategy.revertUndo(player, undoMove, board);
        }

    }
    public void undo(){

        if(!this.Moves.isEmpty()) {


            for(int i = 1; i <= 2; i++) {


                Move undoMove = this.Moves.getLast();

                Player undoPlayer = this.Moves.getLast().getPlayer();

                this.Moves.removeLast();

                this.currentPlayerTurnIndex -= 1;

                if (this.currentPlayerTurnIndex < 0) {

                    this.currentPlayerTurnIndex = players.size() - 1;
                }

                //undo in the board
                int row = undoMove.getCell().getRow();
                int col = undoMove.getCell().getCol();
                Cell undoCell = board.getPlayingBoard().get(row).get(col);
                undoCell.setPlayer(null);
                undoCell.setCellState(CellState.EMPTY);

                //WORK ON REVERT CHECKWINNER HASHMAP'S OF ROW, COL, DIAGONAL WHEN DOING UNDO MOVE

                revertCheckWinnerMapsForUndo(undoPlayer, undoMove, board);

            }

        }
        else {
            System.out.println("UNDO IS NOT VALID HERE !!!");
        }
    }
}

