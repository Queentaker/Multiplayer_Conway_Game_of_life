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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GameManagerTest {
    HumanPlayer testPlayer = new HumanPlayer("bob", Color.CYAN);
    HumanPlayer testPlayer2 = new HumanPlayer("boba", Color.black);
    Grid testGrid =new Grid(3,3);
    List<Player> players = new ArrayList<>();
    Turn aTurn = new Turn(testPlayer,testGrid);

    private GameManager createNewGameManager(List<Player> players, Grid grid, Turn aTurn) throws Exception {
        Constructor<GameManager> leConstructor = GameManager.class.getDeclaredConstructor(List.class, Grid.class);
        leConstructor.setAccessible(true);
        GameManager unConstructor = leConstructor.newInstance(players, grid);
        Field f = unConstructor.getClass().getDeclaredField("turn");
        f.setAccessible(true);
        f.set(unConstructor, aTurn);
        return unConstructor;
    }
    @Test
    public void nextPlayersTurn() throws Exception {
        players.add(testPlayer);
        players.add(testPlayer2);
        GameManager gameManager = createNewGameManager(players, testGrid, aTurn);
        gameManager.nextPlayersTurn();
        Assertions.assertEquals(testPlayer2 ,aTurn.getCurrentPlayersSignature());
    }
    @Test
    public void nextPlayersTurn1() throws Exception {
        players.add(testPlayer);
        players.add(testPlayer2);
        GameManager gameManager = createNewGameManager(players, testGrid, aTurn);
        gameManager.nextPlayersTurn();
        gameManager.nextPlayersTurn();
        Assertions.assertEquals(testPlayer , aTurn.getCurrentPlayersSignature());
    }
}
