package Models;

import strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int currentMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private GameState gameState;
    private Player winner;


    //take in mind that you initialize constructor so you don't get null pointer exception.
     //have getter setter for each
     //Ensure all attributes aer initialized in constructor.

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.moves = new ArrayList<>();
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.currentMovePlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
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

    public int getCurrentMovePlayerIndex() {
        return currentMovePlayerIndex;
    }

    public void setCurrentMovePlayerIndex(int currentMovePlayerIndex) {
        this.currentMovePlayerIndex = currentMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStratergies() {
        return winningStrategies;
    }

    public void setWinningStratergies(List<WinningStrategy> winningStratergies) {
        this.winningStrategies = winningStratergies;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
