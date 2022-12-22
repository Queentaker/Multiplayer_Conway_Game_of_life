package grid;

import exception.IllegalUserInputException;
import player.PlayersSignature;

import java.util.ArrayList;
import java.util.List;

public class Grid implements AddRemoveGridCell {
    //fleightweight still needs to be implemented
    private final List<ArrayList<GridCell>> grid;
    private final int gridSize;
    private final GridCellFactory cellFactory =GridCellFactory.getInstance();
    private void createGrid (){
        for (int i=0;i<gridSize;i++){
            ArrayList<GridCell> row=new ArrayList<GridCell>();
            for (int j=0;j<gridSize;j++){
                row.add(cellFactory.getEmptyGridCell());
            }
            grid.add(row);
        }
    }
    public void setGridCell(int x,int y, GridCell gridCell){
        List<GridCell> row=grid.get(x);
        row.set(y,gridCell);
    }
    public GridCell getGridCell(int x,int y){
        return grid.get(x).get(y);
    }

    public int getGridSize() {
        return gridSize;
    }

    public Grid(int gridSize){
        this.grid= new ArrayList<>();
        this.gridSize=gridSize;
        createGrid();
    }

    //grid constructer so that one can easily create a copy of the grid;
    //todo does not work
    public Grid(Grid anotherGrid){
        this.gridSize=anotherGrid.gridSize;
        this.grid=anotherGrid.grid;
    }

    @Override
    public void addGridCell(PlayersSignature playersSignature, int x, int y) throws IllegalUserInputException {
        assert x>=0 && x<gridSize;
        assert y>=0 && y<gridSize;
        if (getGridCell(x,y).isOccupied()){
            throw new IllegalUserInputException("You can't add a cell to an already occupied one");
        }
        setGridCell(x,y, cellFactory.getGridCell(playersSignature));

    }

    @Override
    public void removeGridCell(PlayersSignature playersSignature, int x, int y) throws IllegalUserInputException{
        assert x>=0 && x<gridSize;
        assert y>=0 && y<gridSize;
        if (!getGridCell(x,y).isOccupied()){
            throw new IllegalUserInputException("you can't remove your an empty cell");
        }
        if (getGridCell(x, y).getPlayersSignature().getPlayerId().equals(playersSignature.getPlayerId())){
            throw new IllegalUserInputException("You can't remove your own cell");
        }
        setGridCell(x,y, cellFactory.getEmptyGridCell());
    }
}