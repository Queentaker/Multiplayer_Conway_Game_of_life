package grid;

import exception.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GridTest {
    Grid grid=new Grid(60,50);
    PlayersSignature bobSignature =new HumanPlayer("bob", Color.BLUE);
    PlayersSignature annaSignature= new HumanPlayer("anna", Color.RED);
    @Test
    public void copyGridTest(){
        Grid copyGrid= new Grid(grid);
        GridCell blueGridCell=new GridCell(bobSignature);
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
        GridCell blueGridCell=new GridCell(bobSignature);
        copyGrid.setGridCell(0,3, blueGridCell);
        Assertions.assertNotEquals(grid.getGridCell(0,3),copyGrid.getGridCell(0,3));
    }
    @Test
    public void placeGridCellfreeCellTest() throws IllegalUserInputException {
        grid.placeGridCell(bobSignature,49,3);
        Assertions.assertEquals(bobSignature,grid.getGridCell(49,3).getPlayersSignature());
    }
    @Test
    public void placeGridCellOccupiedTest() {
        grid.setGridCell(5,10,new GridCell(bobSignature));
        assertThrows(IllegalUserInputException.class,() ->{grid.placeGridCell(bobSignature,5,10);});
    }
    @Test
    public void removeEmptyCellTest(){
        assertThrows(IllegalUserInputException.class,() ->{grid.removeGridCell(bobSignature,5,10);});
    }
    @Test
    public void removeOwnCellTest(){
        grid.setGridCell(5,10,new GridCell(bobSignature));
        assertThrows(IllegalUserInputException.class,() ->{grid.removeGridCell(bobSignature,5,10);});
    }
    @Test
    public void removeOpponentsCellTest() throws IllegalUserInputException{
        grid.setGridCell(5,10,new GridCell(annaSignature));
        grid.removeGridCell(bobSignature,5,10);
        Assertions.assertFalse(grid.getGridCell(5,10).isOccupied());
    }
}
