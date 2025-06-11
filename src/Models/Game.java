package Models;

import strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.moves = new ArrayList<>();
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.currentMovePlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
    }

    //builder pattern to create this complex object and validations,
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private Builder(){}



        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }


        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        private boolean valid(){
            if(this.players.size() < 2){
                return false;
            }
            if(this.players.size() != this.dimension-1){
                return false;
            }
            int botCount = 0;
            for(Player player : this.players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount+=1;
                }
            }
            if(botCount >= 2){
                return false;
            }
            Set<Character> exitingSymbols =  new HashSet<>();
            for(Player player : players){
                if(exitingSymbols.contains(player.getSysmbol().getaChar())){
                    return false;
                }
                exitingSymbols.add(player.getSysmbol().getaChar());
            }
            return true;
        }
        public Game build(){
            if(!valid()){
                throw new RuntimeException("Invalid params for creation of game");
            }
            return new Game(dimension,players,winningStrategies);
        }
    }

    //Methods


    private boolean isValidMove(Cell cell){
        int r = cell.getRow();
        int c = cell.getCol();
        if(r < 0 || c < 0 || r >= board.getSize() || c >= board.getSize()){
            return false;
        }
        return board.getBoard().get(r).get(c).getCellState().equals(CellState.EMPTY);
    }
    public void makeMove(){
        Player Currplayer = players.get(currentMovePlayerIndex);
        Cell ProposedCell = Currplayer.makeMove();
        if(!isValidMove(ProposedCell)){
            return;
        }

        Cell cellInBoard = board.getBoard().get(ProposedCell.getRow()).get(ProposedCell.getCol());
        cellInBoard.setCellState(CellState.FILLED);
        cellInBoard.setPlayer(Currplayer);

        Move move = new Move(Currplayer,cellInBoard);
        moves.add(move);

        if (checkWinner(move, Currplayer)) return;

        if (checkDraw()) return;

        currentMovePlayerIndex+=1;
        currentMovePlayerIndex%=players.size();
    }

    private boolean checkDraw() {
        if(moves.size() == board.getSize() * board.getSize()){
            gameState = GameState.DRAW;
            return true;
        }
        return false;
    }

    private boolean checkWinner(Move move, Player Currplayer) {
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(board, move)){
                gameState = GameState.ENDED;
                winner = Currplayer;
                return true;
            }
        }
        return false;
    }

    public void printResult(){
        if(gameState.equals(GameState.ENDED)){
            System.out.println("Game has Ended");
            System.out.println("Winner is: " + winner.getName());
        }
        else{
            System.out.println("Game is Draw");
        }
    }

    public void printBoard(){
        board.print();
    }



    //getter setter below
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
