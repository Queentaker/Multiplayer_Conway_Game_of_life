package grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;
import java.lang.reflect.Field;

public class GridTest {
    Grid grid=new Grid(8,8);
    PlayersSignature Signature1=new HumanPlayer("bob", Color.BLUE);
    @Test
    public void copyGridTest(){
        Grid copyGrid= new Grid(grid);
        GridCell blueGridCell=new GridCell(Signature1);
        grid.setGridCell(0,3, blueGridCell);
        Assertions.assertNotEquals(grid.getGridCell(0,3),copyGrid.getGridCell(0,3));

    }
    @Test
    public void copyGridTest2(){
        Grid copyGrid= new Grid(grid);
        Assertions.assertEquals(grid.getGridCell(5,5),copyGrid.getGridCell(5,5));
    }
    @Test
    public void copyGridTest3(){
        Grid copyGrid=new Grid(grid);
        GridCell blueGridCell=new GridCell(Signature1);
        copyGrid.setGridCell(0,3, blueGridCell);
        Assertions.assertNotEquals(grid.getGridCell(0,3),copyGrid.getGridCell(0,3));
    }
}
