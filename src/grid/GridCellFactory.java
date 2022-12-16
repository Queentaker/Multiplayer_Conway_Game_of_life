package grid;

import java.util.HashMap;

public class GridCellFactory {
    private HashMap<String,GridCell> occupiedGridCells= new HashMap<>();
    private GridCell emptyCell;

    public GridCell getEmptyGridCell() {
        if (emptyCell==null){
            emptyCell= new GridCell();
        }
        return emptyCell;
    }

    public GridCell getGridCell(String id){
        if (!occupiedGridCells.containsKey(id)){
            occupiedGridCells.put(id, new GridCell(id));
        }
        return occupiedGridCells.get(id);
    }

    //todo
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
