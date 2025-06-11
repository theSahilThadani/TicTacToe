import Models.*;
import controller.GameController;
import strategies.winningstrategies.OrderOneColumnWinningStrategy;
import strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import strategies.winningstrategies.OrderOneRowWinnigStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create game
        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);
        Game game  = gameController.createGame(
                3,
                List.of(
                        new Player(new Symbol('X'), "Sahil", PlayerType.HUMAN),
                        new Bot(new Symbol('O'), "BOT", BotDifficultyLevel.EASY)
                ),
                List.of(
                        new OrderOneColumnWinningStrategy(),
                        new OrderOneRowWinnigStrategy(),
                        new OrderOneDiagonalWinningStrategy()
                )
        );

        //while game status in progress
        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            //print board
            gameController.displayBoard(game);
            //print if undo
            System.out.println("Do you want to undo? (Y/N)");
            //if yes -> call undo
            String input = scanner.next();
            if(input.equals("Y")){
                gameController.undo(game);
            }else{
                //move next player
                gameController.makeMove(game);
            }
        }
        //check status of game
        GameState gameState = gameController.getGameState(game);
        // if winner -> print winner
        gameController.printResult(game);
    }
}
