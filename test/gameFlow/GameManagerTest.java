package gameFlow;

import exception.IllegalUserInputException;
import grid.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameManagerTest {
    HumanPlayer testPlayer = new HumanPlayer("bob", Color.CYAN);
    Grid testGrid =new Grid(3,3);
    List<Player> players = new ArrayList<>();

    List<CoordinatesTuple> startConfiguration= new ArrayList<>();
    GameManager gameManager = new GameManager(players);
    @Test
    public void nextPlayersTurnTest(){
        gameManager.nextPlayersTurn();
        // how to get the currentIndex
    }

/*
    @Test
    public void startGameTest(){
        gameManager.startGame(startConfiguration, players, 3, 3);
        // what could I get??
    }
*/

}
