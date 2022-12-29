package grid;

import gameFlow.GameManager;
import player.PlayersSignature;

import java.util.*;

public class EvolveNextGen {
    private Grid beforeEvolution;
    private int upperBoundaryRow;
    private int upperBoundaryColumn;
    private final int lowerBoundary = 0;
    
    private final GridCellFactory factory = GridCellFactory.getInstance();

    public void evolve(Grid grid) {
        beforeEvolution = new Grid(grid);
        upperBoundaryRow = beforeEvolution.getGridHeight();
        upperBoundaryColumn = beforeEvolution.getGridWidth();

        for (int x = 0; x < upperBoundaryRow; x++) {
            for (int y = 0; y < upperBoundaryColumn; y++) {
                Map<PlayersSignature, NumNeighbors> aliveNeighborsMap = getAliveNeighborsMap(x, y);
                NumNeighbors amountofNeighbors=totalNeighbors(aliveNeighborsMap);
                boolean alreadyAlive=grid.getGridCell(x,y).isOccupied();
                if (doesGridCellLive(amountofNeighbors,alreadyAlive)){
                    if (!alreadyAlive){
                        grid.setGridCell(x,y,factory.getGridCell(dominantPlayer(aliveNeighborsMap)));
                    }
                    //else stays the same
                }
                else {
                    grid.setGridCell(x, y, factory.getEmptyGridCell());
                }

            }
        }
    }
        //work needs to be done


    private NumNeighbors totalNeighbors(Map<PlayersSignature, NumNeighbors> AliveNeighbors){
        NumNeighbors neighbors=NumNeighbors.Zero;
        for (Map.Entry<PlayersSignature, NumNeighbors> entry : AliveNeighbors.entrySet()){
            NumNeighbors numNeighbors=entry.getValue();
            neighbors=NumNeighbors.getEnum(neighbors.value+numNeighbors.value);
        }
        return neighbors;

    }
    private PlayersSignature dominantPlayer(Map<PlayersSignature, NumNeighbors> AliveNeighbors){
        NumNeighbors mostNeighbors=NumNeighbors.Zero;

        PlayersSignature signature=null;
        for (Map.Entry<PlayersSignature, NumNeighbors> entry : AliveNeighbors.entrySet()){
            PlayersSignature playersSignature= entry.getKey();
            NumNeighbors numNeighbors=entry.getValue();
            if (mostNeighbors.value<numNeighbors.value){
                mostNeighbors=numNeighbors;
                signature=playersSignature;
            }
        }
        assert signature!=null;
        return signature;

    }

    private Map<PlayersSignature, NumNeighbors> getAliveNeighborsMap(int x, int y) {
        Map<PlayersSignature, NumNeighbors> neighborCountMap = new HashMap<PlayersSignature, NumNeighbors>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++){
                if (!(i==0 & j==0)) {
                    int row = x + i;
                    int colum = y + j;
                    if (doesCoordinateExist(row, colum)) {
                        updateHashTable(row, colum, neighborCountMap);
                    }
                }
            }
        }
        return neighborCountMap;
    }

    private boolean doesCoordinateExist(int row, int column) {
        return row >= lowerBoundary && column >= lowerBoundary && row < upperBoundaryRow && column < upperBoundaryColumn;
    }

    private void updateHashTable(int row, int colum, Map<PlayersSignature, NumNeighbors> neighborCountMap) {
        GridCell gridCell = beforeEvolution.getGridCell(row, colum);
        if (gridCell.isOccupied()) {
            PlayersSignature signature = gridCell.getPlayersSignature();
            if (!neighborCountMap.containsKey(signature)) {
                neighborCountMap.put(signature, NumNeighbors.One);
            } else {
                neighborCountMap.put(signature, NumNeighbors.getEnum(neighborCountMap.get(signature).value + 1));
            }
        }
    }

    private boolean doesGridCellLive(NumNeighbors numNeighbors,boolean alreadyAlive) {
        if (alreadyAlive){
            return requiredNeighborsToSurvive(numNeighbors);
        }
        else{
            return requiredNeighborsCreate(numNeighbors);
        }
    }

    private boolean requiredNeighborsToSurvive(NumNeighbors aliveNeighbors) {
        return aliveNeighbors == NumNeighbors.Two || aliveNeighbors == NumNeighbors.Three;
    }
    private boolean requiredNeighborsCreate(NumNeighbors aliveNeighbors){
        return aliveNeighbors==NumNeighbors.Three;
    }

    //this needs to be done for the scenario that a player a has 2 neighboring and player 3 b to the cell x
    //randomly a playerSignature is going to be selected

}
