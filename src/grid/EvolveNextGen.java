package grid;

import player.PlayersSignature;

import java.util.*;

public class EvolveNextGen {
    private Grid beforeEvolution;
    private int upperBoundary;
    private int lowerBoundary = 0;
    private final GridCellFactory factory = GridCellFactory.getInstance();

    public void evolve(Grid grid) {
        beforeEvolution = new Grid(grid);
        upperBoundary = beforeEvolution.getGridSize();

        for (int x = 0; x < upperBoundary; x++) {
            for (int y = 0; y < upperBoundary; y++) {
                Map<PlayersSignature, NumNeighbors> aliveNeighborsMap = getAliveNeighborsMap(x, y);
                if (!doesGridCellSurvive(aliveNeighborsMap)){
                    grid.setGridCell(x,y, factory.getEmptyGridCell());
                }
                else {
                    grid.setGridCell(x,y, factory.getGridCell(getSignatureAliveCell(aliveNeighborsMap)));
                }
            }
        }
        //work needs to be done
    }

    private Map<PlayersSignature, NumNeighbors> getAliveNeighborsMap(int x, int y) {
        Map<PlayersSignature, NumNeighbors> neighborCountMap = new HashMap<PlayersSignature, NumNeighbors>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++){
                if (!(i==0& j==0)) {
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

    private boolean doesCoordinateExist(int row, int colum) {
        return row >= lowerBoundary && colum >= lowerBoundary && row < upperBoundary && colum < upperBoundary;
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

    private boolean doesGridCellSurvive(Map<PlayersSignature, NumNeighbors> numNeighborsMap) {
        for (NumNeighbors numberOfNeighbors : numNeighborsMap.values()) {
            if (requiredNeighborsToSurvive(numberOfNeighbors)) {
                return true;
            }
        }
        return false;
    }

    private boolean requiredNeighborsToSurvive(NumNeighbors aliveNeighbors) {
        return aliveNeighbors == NumNeighbors.Two || aliveNeighbors == NumNeighbors.Three;
    }
    private PlayersSignature getSignatureAliveCell(Map<PlayersSignature, NumNeighbors> numNeighborsMap){
        List<PlayersSignature> survivingPlayersSignatures=new ArrayList<>();
        for (Map.Entry<PlayersSignature, NumNeighbors> entry : numNeighborsMap.entrySet()){
            PlayersSignature playersSignature=entry.getKey();
            NumNeighbors numNeighbors=entry.getValue();
            if (requiredNeighborsToSurvive(numNeighbors)){
                survivingPlayersSignatures.add(playersSignature);
            }
        }
        assert survivingPlayersSignatures.size()>0;
        return randomValidPlayer(survivingPlayersSignatures);
    }
    //this needs to be done for the scenario that a player a has 2 neigbhoring and player 3 b to the cell x
    //randomly a playerSignature is going to be selected
    private PlayersSignature randomValidPlayer(List<PlayersSignature> survivingPlayersSignatures){
        int length=survivingPlayersSignatures.size();
        Random rand= new Random();
        return survivingPlayersSignatures.get(rand.nextInt(length));
    }
}
