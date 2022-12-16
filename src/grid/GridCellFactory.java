package grid;

import player.PlayersSignature;

import java.util.HashMap;

public class GridCellFactory {
    //todo make factory singleton to allow global access
    private final HashMap<PlayersSignature,GridCell> occupiedGridCells= new HashMap<>();
    private GridCell emptyCell;

    public GridCell getEmptyGridCell() {
        if (emptyCell==null){
            emptyCell= new GridCell();
        }
        return emptyCell;
    }

    public GridCell getGridCell(PlayersSignature playersSignature){
        if (!occupiedGridCells.containsKey(playersSignature)){
            occupiedGridCells.put(playersSignature, new GridCell(playersSignature));
        }
        return occupiedGridCells.get(playersSignature);
    }

        /*
public class FlyweightFactory {
    private HashMap<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String intrinsicState) {
        if (!flyweights.containsKey(intrinsicState)) {
            flyweights.put(intrinsicState, new Flyweight(intrinsicState));
        }
        return flyweights.get(intrinsicState);
    }
}



     */
}
