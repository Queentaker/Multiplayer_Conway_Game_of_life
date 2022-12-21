package grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;

public class GridCellFactoryTest {
    PlayersSignature playersSignatureBob=new HumanPlayer("bob", Color.BLUE);
    GridCellFactory gridCellFactory=GridCellFactory.getInstance();
    @Test
    public void getEmptyCellTest(){
        GridCell emptyGridCell1=gridCellFactory.getEmptyGridCell();
        GridCell emptyGridCell2=gridCellFactory.getEmptyGridCell();
        Assertions.assertEquals(emptyGridCell1,emptyGridCell2);
    }
    @Test
    public void getPlayer1CellTest(){
        GridCell bobGridCell1=gridCellFactory.getGridCell(playersSignatureBob);
        GridCell bobGridCell2=gridCellFactory.getGridCell(playersSignatureBob);
        Assertions.assertEquals(bobGridCell1,bobGridCell2);
    }
    @Test
    public void singletonTest(){
        GridCellFactory gridCellFactory2=GridCellFactory.getInstance();
        Assertions.assertEquals(gridCellFactory,gridCellFactory2);
    }
}
