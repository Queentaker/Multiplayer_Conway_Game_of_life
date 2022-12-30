package gameFlow;

import GUI.FrameObserver;
import GUI.GameFrame;
import exception.IllegalUserInputException;
import grid.CoordinatesTuple;
import grid.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.Player;
import setUp.MockObserver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameManagerTest {
    HumanPlayer testPlayer = new HumanPlayer("bob", Color.CYAN);
    HumanPlayer testPlayer2 = new HumanPlayer("boba", Color.black);
    Grid testGrid =new Grid(3,3);
    List<Player> players = new ArrayList<>();

    MockObserver gameFrame = new MockObserver();
    Turn aTurn = new Turn(testPlayer,testGrid);

    /*Untestable??
    @Test
    public void nextPlayersTurnTest(){
        gameManager.nextPlayersTurn();
        // how to get the currentIndex
    }


    @Test
    public void setMeasurementsTest(){

        // what could I get??
    }*/
    @Test
    public void nextPlayersTurn(){
        players.add(testPlayer);
        GameManager gameManager = GameManager.getInstance(players,testGrid);
        gameManager.nextPlayersTurn();
        Assertions.assertEquals(testPlayer,aTurn.getCurrentPlayersSignature());
    }
    @Test
    public void nextPlayersTurn1(){
        players.add(testPlayer);
        players.add(testPlayer2);
        GameManager gameManager = GameManager.getInstance(players,testGrid);
        gameManager.nextPlayersTurn();
        Assertions.assertEquals(testPlayer,aTurn.getCurrentPlayersSignature());
    }
}
