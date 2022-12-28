package grid;

import player.PlayersSignature;

import java.util.HashMap;

public class GridCellFactory {
    private static GridCellFactory uniqueInstance;
    private GridCellFactory(){};
    public static synchronized GridCellFactory  getInstance(){
        if (uniqueInstance==null){
            uniqueInstance=new GridCellFactory();
        }
        return uniqueInstance;
    }
    private final HashMap<PlayersSignature,GridCell> occupiedGridCells= new HashMap<>();
    private GridCell emptyCell;

    public GridCell getEmptyGridCell() {
        if (emptyCell==null){
            emptyCell= new GridCell();
        }
        return emptyCell;
    }
    //dangerous bad code
    public GridCell getGridCell(PlayersSignature playersSignature){
        if (!occupiedGridCells.containsKey(playersSignature)){
            occupiedGridCells.put(playersSignature, new GridCell(playersSignature));
        }
        return occupiedGridCells.get(playersSignature);
    }

}
