package grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;

public class GridCellTest {
    GridCell emptyCell=new GridCell();
    PlayersSignature bobSignature=new HumanPlayer("bob", Color.GREEN);
    GridCell bobCells=new GridCell(bobSignature);

    @Test
    public void getColorEmptyCellTest(){
        Assertions.assertEquals(emptyCell.getGridCellColor(),Color.white);
    }
    @Test
    public void getColorOccupiedCellTest(){
        Assertions.assertEquals(bobSignature.getPlayerColor(),bobCells.getGridCellColor());
    }
}
