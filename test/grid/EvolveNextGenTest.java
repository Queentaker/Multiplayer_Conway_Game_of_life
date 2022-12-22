package grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;

public class EvolveNextGenTest {

    Grid grid=new Grid(3);
    PlayersSignature signatureBob=new HumanPlayer("bob", Color.BLUE);
    PlayersSignature signatureAnna=new HumanPlayer("anna",Color.GREEN);
    EvolveNextGen evolveNextGen =new EvolveNextGen();

    @Test
    public void evolveTest(){
        // in 3*3 all cells belonging to the same four cells should survive namley the corner ones
        for (int x=0;x< grid.getGridSize();x++){
            for (int y=0;y< grid.getGridSize();y++){
                grid.setGridCell(x,y,new GridCell(signatureAnna));
            }
        }
        evolveNextGen.evolve(grid);
        for (int x=0;x< grid.getGridSize();x=x+2){
            for (int y=0;y< grid.getGridSize();y=y+2){
                Assertions.assertEquals(grid.getGridCell(x,y).getPlayersSignature(),signatureAnna);
            }
        }

    }
}
