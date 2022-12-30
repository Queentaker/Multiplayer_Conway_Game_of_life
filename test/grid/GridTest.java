package grid;

import exception.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GridTest {
    Grid grid=new Grid(60,50);
    Grid grid2 = new Grid (3,3);
    Grid grid3 = new Grid(1,1);
    PlayersSignature bobSignature =new HumanPlayer("bob", Color.BLUE);
    PlayersSignature annaSignature= new HumanPlayer("anna", Color.RED);
    GridCell testCell;
    @Test
    public void cellsAlivePlayerTest() throws IllegalUserInputException, NoSuchFieldException, IllegalAccessException {
        testCell = new GridCell();
        grid3.placeGridCell(0, 0, bobSignature);
        Field fSignatureGrid = testCell.getClass().getDeclaredField("playersSignature");
        fSignatureGrid.setAccessible(true);
        fSignatureGrid.set(testCell,bobSignature);
        Assertions.assertEquals(1,grid3.cellsAlivePlayer(bobSignature));
    }

    @Test
    public void getGridDimensions(){
        assertEquals(60, grid.getGridHeight());
        assertEquals(50, grid.getGridWidth());
    }

    @Test
    public void getColorsTest(){
        ArrayList<ArrayList<Color>> testColors = new ArrayList<ArrayList<Color>>();
        for(int i = 0; i < 3; i++){
            ArrayList<Color> row = new ArrayList<Color>();
            for( int j = 0; j<3; j++){
                row.add(Color.WHITE);
            }
            testColors.add(row);
        }
        Assertions.assertEquals(testColors,grid2.getColors());
    }
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
        grid.placeGridCell(49, 3, bobSignature);
        Assertions.assertEquals(bobSignature,grid.getGridCell(49,3).getPlayersSignature());
    }
    @Test
    public void placeGridCellOccupiedTest() {
        grid.setGridCell(5,10,new GridCell(bobSignature));
        assertThrows(IllegalUserInputException.class,() ->{grid.placeGridCell(5, 10, bobSignature);});
    }
    @Test
    public void removeEmptyCellTest(){
        assertThrows(IllegalUserInputException.class,() ->{grid.removeGridCell(5, 10, bobSignature);});
    }
    @Test
    public void removeOwnCellTest(){
        grid.setGridCell(5,10, new GridCell(bobSignature));
        Assertions.assertThrows(IllegalUserInputException.class, () -> {
            grid.removeGridCell(5, 10, bobSignature);
        });
    }
    @Test
    public void removeOpponentsCellTest() throws IllegalUserInputException{
        grid.setGridCell(5,10,new GridCell(annaSignature));
        grid.removeGridCell(5, 10, bobSignature);
        Assertions.assertFalse(grid.getGridCell(5,10).isOccupied());
    }

    @Test
    public void preconditionRemoveGridCell() throws IllegalUserInputException{
        Assertions.assertThrows(AssertionError.class, () -> {
            grid2.removeGridCell(-1, 1, bobSignature);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            grid2.removeGridCell(0, -1, bobSignature);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            grid2.removeGridCell(200, 0, bobSignature);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            grid2.removeGridCell(0, 200, bobSignature);
        });
    }

    @Test
    public void preconditionPlaceGridCell() throws IllegalUserInputException{
        Assertions.assertThrows(AssertionError.class, () -> {
            grid2.placeGridCell(-1, 1, bobSignature);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            grid2.placeGridCell(0, -1, bobSignature);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            grid2.placeGridCell(200, 0, bobSignature);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            grid2.placeGridCell(0, 200, bobSignature);
        });
    }

    @Test
    public void preconditionCopyGrid() throws Exception {
        Grid grid4 = new Grid(61, 50);
        Method m = grid4.getClass().getDeclaredMethod("copyGrid", Grid.class);
        m.setAccessible(true);
        Assertions.assertThrows(AssertionError.class, () -> {
            try {
                m.invoke(grid4, grid);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        });
        Grid grid5 = new Grid(60, 51);
        Assertions.assertThrows(AssertionError.class, () -> {
            try {
                m.invoke(grid5, grid);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        });
    }

    @Test
    public void preconditionConstructerOtherGrid() throws Exception {
        Assertions.assertThrows(AssertionError.class, () -> {
            Grid grid4 = null;
            new Grid(grid4);
        });
    }

    @Test
    public void preconditionConstructer() throws Exception {
        Assertions.assertThrows(AssertionError.class, () -> {
            new Grid(2, -1);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            new Grid(-1, 2);
        });
    }
}


