package grid;

import player.PlayersSignature;

import java.util.*;

public class EvolveNextGen {

    public static void evolve(Grid grid) {
        Grid beforeEvolution = new Grid(grid);
        int upperBoundaryRow = beforeEvolution.getGridHeight();
        int upperBoundaryColumn = beforeEvolution.getGridWidth();
        GridCellFactory factory=GridCellFactory.getInstance();

        for (int row = 0; row < upperBoundaryRow; row++) {
            for (int colum = 0; colum < upperBoundaryColumn; colum++) {
                Map<PlayersSignature, NumNeighbors> aliveNeighborsMap = getAliveNeighborsMap(beforeEvolution,row, colum, upperBoundaryRow,upperBoundaryColumn);
                NumNeighbors amountofNeighbors=totalNeighbors(aliveNeighborsMap);
                boolean alreadyAlive=grid.getGridCell(row,colum).isOccupied();
                if (doesGridCellLive(amountofNeighbors,alreadyAlive)){
                    if (!alreadyAlive){
                        grid.setGridCell(row,colum,factory.getGridCell(dominantPlayer(aliveNeighborsMap)));
                    }
                }
                else {
                    grid.setGridCell(row, colum, factory.getEmptyGridCell());
                }

            }
        }
    }

    private static NumNeighbors totalNeighbors(Map<PlayersSignature, NumNeighbors> AliveNeighbors){
        NumNeighbors neighbors=NumNeighbors.Zero;
        for (Map.Entry<PlayersSignature, NumNeighbors> entry : AliveNeighbors.entrySet()){
            NumNeighbors numNeighbors=entry.getValue();
            neighbors=NumNeighbors.getEnum(neighbors.value+numNeighbors.value);
        }
        return neighbors;
    }

    private static PlayersSignature dominantPlayer(Map<PlayersSignature, NumNeighbors> AliveNeighbors){
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

    private static Map<PlayersSignature, NumNeighbors> getAliveNeighborsMap(Grid beforeEvolution, int a, int b, int upperBoundaryRow, int upperBoundaryColumn) {
        Map<PlayersSignature, NumNeighbors> neighborCountMap = new HashMap<PlayersSignature, NumNeighbors>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++){
                if (!(i==0 & j==0)) {
                    int row = a + i;
                    int colum = b + j;
                    if (doesCoordinateExist(row, colum,upperBoundaryRow,upperBoundaryColumn)) {
                        updateHashTable(beforeEvolution,row, colum, neighborCountMap);
                    }
                }
            }
        }
        return neighborCountMap;
    }

    private static boolean doesCoordinateExist(int row, int column,int upperBoundaryRow,int upperBoundaryColumn) {
        int lowerBoundary = 0;
        return row >= lowerBoundary && column >= lowerBoundary && row < upperBoundaryRow && column < upperBoundaryColumn;
    }

    private static void updateHashTable(Grid beforeEvolution, int row, int colum, Map<PlayersSignature, NumNeighbors> neighborCountMap) {
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

    private static boolean doesGridCellLive(NumNeighbors numNeighbors,boolean alreadyAlive) {
        if (alreadyAlive){
            return requiredNeighborsToSurvive(numNeighbors);
        }
        else{
            return requiredNeighborsCreate(numNeighbors);
        }
    }

    private static boolean requiredNeighborsToSurvive(NumNeighbors aliveNeighbors) {
        return aliveNeighbors == NumNeighbors.Two || aliveNeighbors == NumNeighbors.Three;
    }

    private static boolean requiredNeighborsCreate(NumNeighbors aliveNeighbors){
        return aliveNeighbors==NumNeighbors.Three;
    }
}
