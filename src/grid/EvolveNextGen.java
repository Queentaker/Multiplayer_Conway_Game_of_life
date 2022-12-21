package grid;

import player.PlayersSignature;

import java.util.HashMap;
import java.util.Map;

public class EvolveNextGen {
    private Grid beforeEvolution;
    private int upperBoundary;
    private final GridCellFactory gridCellFactory=GridCellFactory.getInstance();
    public void evolve(Grid grid){
        beforeEvolution= new Grid(grid);
        upperBoundary= beforeEvolution.getGridSize();

        for (int i=0; i<upperBoundary;i++){
            for (int j=0;j<upperBoundary;j++){
                //does
            }
        }
        //work needs to be done
    }
    private NumNeighbors getAliveNeighbors(int x, int y){
        Map<PlayersSignature,NumNeighbors> neighborCount=new HashMap<PlayersSignature,NumNeighbors>();

        NumNeighbors counterAliveNeighbors=NumNeighbors.Zero;
        //needs to be implemented correctly current version doesn't work
        for (int i=-1 ; i<2 ; i++)
            for (int j=-1 ; j<2 ; j++)
                if (i !=0 && j != 0)
                {
                    int row = x + i;
                    int colum = y + j;

                    int lowerBoundary = 0;
                    if (row >= lowerBoundary && colum >= lowerBoundary && row < upperBoundary && colum < upperBoundary)
                    {
                        GridCell gridCell=beforeEvolution.getGridCell(row,colum);
                        //if (gridCell.isOccupied() && gridCell.getPlayerId()==playerId)
                        //{
                          //  counterAliveNeighbors++;
                        //}
                    }
                }
        return counterAliveNeighbors;
    }
    private boolean doesGridCellSurvive(int x, int y){
        NumNeighbors aliveNeighbors=getAliveNeighbors(x,y);
        return aliveNeighbors==NumNeighbors.Two || aliveNeighbors==NumNeighbors.Three;
    }
}
