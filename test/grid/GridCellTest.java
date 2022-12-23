package grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;

import java.awt.*;

public class GridCellTest {
    HumanPlayer bob = new HumanPlayer("bob", Color.RED);
    GridCell myTestCellEmpty = new GridCell();
    GridCell myTestCellPlayer = new GridCell(bob);
    @Test
    public void getGridCellColorTest(){
        Assertions.assertEquals(myTestCellEmpty.getGridCellColor(), Color.WHITE);
    }
    @Test
    public void getGridCellColorTest2(){
        Assertions.assertEquals(myTestCellPlayer.getGridCellColor(),Color.RED);
    }
    @Test
    public void isOccupiedTest(){
        Assertions.assertEquals(myTestCellEmpty.isOccupied(),false);
    }

    @Test
    public void isOccupiedTest1(){
        Assertions.assertEquals(myTestCellPlayer.isOccupied(),true);
    }
    @Test
    public void getPlayersSignatureTest(){
        Assertions.assertEquals(myTestCellPlayer.getPlayersSignature(),bob);
    }
}
