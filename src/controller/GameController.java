package controller;

import Models.Game;
import Models.GameState;
import Models.Player;
import strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        return Game.getBuilder()
                .setDimension(dimension)
                .setWinningStrategies(winningStrategies)
                .setPlayers(players)
                .build();
    }
    public void displayBoard(Game game){

    }
    public void undo(Game game){

    }
    public void makeMove(Game game){

    }
    public GameState getGameState(Game game){
        return game.getGameState();
    }
    public void printResult(Game game){

    }
}
