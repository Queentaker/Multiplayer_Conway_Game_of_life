package grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;

public class EvolveNextGenTest {

    Grid grid=new Grid(30,30);
    PlayersSignature signatureBob=new HumanPlayer("bob", Color.BLUE);
    PlayersSignature signatureAnna=new HumanPlayer("anna",Color.GREEN);
    EvolveNextGen evolveNextGen =new EvolveNextGen();

    @Test
    public void evolveTest(){
        // in 3*3 all cells belonging to the same four cells should survive namley the corner ones
        for (int x=0;x< 3;x++){
            for (int y=0;y< 3;y++){
                grid.setGridCell(x,y,new GridCell(signatureAnna));
            }
        }
        evolveNextGen.evolve(grid);
        for (int x=0;x< 3;x=x+2){
            for (int y=0;y< 3;y=y+2){
                Assertions.assertEquals(grid.getGridCell(x,y).getPlayersSignature(),signatureAnna);
            }
        }
        Assertions.assertFalse(grid.getGridCell(1, 1).isOccupied());
        Assertions.assertFalse(grid.getGridCell(0,1).isOccupied());

    }
    @Test
    public void evolveTest2(){
        grid.setGridCell(0,0,new GridCell(signatureAnna));
        grid.setGridCell(0,1,new GridCell(signatureAnna));
        grid.setGridCell(0,2,new GridCell(signatureBob));
        grid.setGridCell(1,2,new GridCell(signatureBob));
        grid.setGridCell(2,2,new GridCell(signatureBob));
        grid.setGridCell(2,1,new GridCell(signatureBob));
        evolveNextGen.evolve(grid);
        Assertions.assertEquals(grid.getGridCell(1,1).getPlayersSignature(),signatureAnna);
    }
    @Test
    public void evolveTest3(){
        grid.setGridCell(0,0,new GridCell(signatureAnna));
        grid.setGridCell(0,2,new GridCell(signatureBob));
        evolveNextGen.evolve(grid);
        Assertions.assertFalse(grid.getGridCell(1, 1).isOccupied());
    }
}
