package gameFlow;

import grid.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.Player;
import player.PlayersSignature;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.List;

public class TurnTest {

    HumanPlayer testPlayer = new HumanPlayer("bob", Color.CYAN);
    Turn testTurn = new Turn(testPlayer);
    Grid testGrid =new Grid(3,3);
    @Test
    public void playerSignatureTest(){
        PlayersSignature returnValue = testTurn.getCurrentPlayersSignature();
        Assertions.assertEquals(testPlayer, returnValue);
    }

    @Test
    public void playerNameTest(){
        String returnName = testTurn.getName();
        Assertions.assertEquals("bob", returnName);
    }
    @Test
    public void getCellsAlivePlayerTest() throws NoSuchFieldException, IllegalAccessException {
        Field fgrid = testTurn.getClass().getDeclaredField("grid");
        fgrid.setAccessible(true);
        fgrid.set(testTurn,testGrid);
        int cellsAlive = testTurn.getCellsAlivePlayer(testPlayer);
        Assertions.assertEquals(0,cellsAlive);
    }
}
