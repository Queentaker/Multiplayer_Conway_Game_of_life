package gameFlow;

import exception.IllegalUserInputException;
import grid.CoordinatesTuple;
import grid.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;
import java.lang.reflect.Field;

public class TurnTest {

    HumanPlayer testPlayer = new HumanPlayer("bob", Color.CYAN);

    Grid testGrid =new Grid(3,3);
    CoordinatesTuple coordinatesTupleTest = new CoordinatesTuple(1,1);
    Turn testTurn = new Turn(testPlayer,testGrid);
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
    public void getCellsAlivePlayerTest() throws NoSuchFieldException, IllegalAccessException, IllegalUserInputException {
        testGrid.placeGridCell(1, 1, testPlayer);
        testGrid.placeGridCell(0, 1, testPlayer);
        Field fgrid = testTurn.getClass().getDeclaredField("grid");
        fgrid.setAccessible(true);
        fgrid.set(testTurn,testGrid);
        int cellsAlive = testTurn.getCellsAlivePlayer(testPlayer);
        Assertions.assertEquals(2,cellsAlive);
    }
    /*
    @Test
    public void getPlayersSignatureTest(){
        List<Player> testPlayers = new ArrayList<>();
        testPlayers.add(0,testPlayer);
        List<PlayersSignature> testPlayersSignatures = new ArrayList<>();
        testPlayersSignatures.add(0,testPlayer);
        Assertions.assertEquals(testPlayer,testTurn.);
    }*/
    @Test
    public void coordinatesTest(){
        testTurn.setCoordinates(coordinatesTupleTest);
        Assertions.assertEquals(coordinatesTupleTest,testTurn.getCoordinates());
    }
}
