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
    public void evolveTest4(){
        grid.setGridCell(0,1,new GridCell(signatureAnna));
        grid.setGridCell(0,2,new GridCell(signatureAnna));
        grid.setGridCell(1,0,new GridCell(signatureAnna));
        evolveNextGen.evolve(grid);
        Assertions.assertEquals(grid.getGridCell(1,1).getPlayersSignature(),signatureAnna);
    }
    @Test
    public void evolveTest5(){
        grid.setGridCell(0,1,new GridCell(signatureAnna));
        grid.setGridCell(0,2,new GridCell(signatureAnna));
        grid.setGridCell(1,0,new GridCell(signatureBob));
        evolveNextGen.evolve(grid);
        Assertions.assertEquals(grid.getGridCell(1,1).getPlayersSignature(),signatureAnna);
    }

    @Test
    public void evolveTest6(){
        grid.setGridCell(0,1,new GridCell(signatureAnna));
        grid.setGridCell(0,2,new GridCell(signatureAnna));
        evolveNextGen.evolve(grid);
        Assertions.assertFalse(grid.getGridCell(1,1).isOccupied());
    }
    @Test
    public void evolveTest7(){
        grid.setGridCell(1,1,new GridCell(signatureAnna));
        grid.setGridCell(0,1,new GridCell(signatureAnna));
        grid.setGridCell(0,2,new GridCell(signatureAnna));
        evolveNextGen.evolve(grid);
        Assertions.assertEquals(grid.getGridCell(1,1).getPlayersSignature(),signatureAnna);

    }

}
