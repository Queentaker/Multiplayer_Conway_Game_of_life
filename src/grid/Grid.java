package grid;

import exception.IllegalUserInputException;
import player.PlayersSignature;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Grid implements AddRemoveGridCell{

    private final EvolveNextGen evolveNextGen=new EvolveNextGen();

    private final List<ArrayList<GridCell>> grid;
    private final int gridHeight;
    private final int gridWidth;
    private final GridCellFactory cellFactory =GridCellFactory.getInstance();
    private void createGrid (){
        for (int i=0;i<gridHeight;i++){
            ArrayList<GridCell> row=new ArrayList<GridCell>();
            for (int j=0;j<gridWidth;j++){
                row.add(cellFactory.getEmptyGridCell());
            }
            grid.add(row);
        }
    }

    public Grid(int height, int width){
        assert height>0;
        assert width>0;
        this.grid= new ArrayList<>();
        this.gridHeight=height;
        this.gridWidth=width;
        createGrid();
    }
    //grid constructer so that one can easily create a copy of the grid;
    public Grid(Grid anotherGrid){
        assert anotherGrid!=null;
        this.gridHeight=anotherGrid.gridHeight;
        this.gridWidth=anotherGrid.gridWidth;
        this.grid=copyGrid(anotherGrid);
    }
    private List<ArrayList<GridCell>> copyGrid(Grid anotherGrid){
        assert gridHeight== anotherGrid.gridHeight;
        assert gridWidth==anotherGrid.gridWidth;
        List<ArrayList<GridCell>> copy=new ArrayList<>();
        for (int x=0;x<gridHeight;x++){
            ArrayList<GridCell> row=new ArrayList<GridCell>();
            for (int y=0;y<gridWidth;y++){
                row.add(anotherGrid.getGridCell(x,y));
            }
            copy.add(row);
        }
        return copy;
    }

    public void evolve(){
        evolveNextGen.evolve(this);
    }

    public void setGridCell(int x,int y, GridCell gridCell){
        List<GridCell> row=grid.get(x);
        row.set(y,gridCell);
    }
    public GridCell getGridCell(int x,int y){
        return grid.get(x).get(y);
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    @Override
    public void placeGridCell(PlayersSignature playersSignature, int x, int y) throws IllegalUserInputException {
        assert x>=0 && x<gridHeight;
        assert y>=0 && y<gridHeight;
        if (getGridCell(x,y).isOccupied()){
            throw new IllegalUserInputException("You can't add a cell to an already occupied one");
        }
        setGridCell(x,y, cellFactory.getGridCell(playersSignature));
    }

    @Override
    public void removeGridCell(PlayersSignature playersSignature, int x, int y) throws IllegalUserInputException{
        assert x>=0 && x<gridHeight;
        assert y>=0 && y<gridHeight;
        if (!getGridCell(x,y).isOccupied()){
            throw new IllegalUserInputException("you can't remove your an empty cell");
        }
        if (getGridCell(x, y).getPlayersSignature().getPlayerId().equals(playersSignature.getPlayerId())){
            throw new IllegalUserInputException("You can't remove your own cell");
        }
        setGridCell(x,y, cellFactory.getEmptyGridCell());
    }

    //checks for all cells alive from a player
    //shouldnt it be x in range gridHeight and y in range grid
    public int cellsAlivePlayer(PlayersSignature playersSignature){
        int cellsAlivePlayer=0;
        for(int x = 0; x < gridHeight; x++){
            for(int y = 0; y < gridWidth; y++){
                if(/*grid.getGridCell(x,y).isOccupied() &&*/ this.getGridCell(x,y).getPlayersSignature()==playersSignature){
                    cellsAlivePlayer++;
                }
            }
        }
        return cellsAlivePlayer;
    }

    public ArrayList<ArrayList<Color>> getColors(){
        ArrayList<ArrayList<Color>> colorsArray = new ArrayList<ArrayList<Color>>();
        for (int x=0;x<gridHeight;x++){
            ArrayList<Color> row=new ArrayList<Color>();
            for (int y=0;y<gridWidth;y++){
                row.add(getGridCell(x,y).getGridCellColor());
            }
            colorsArray.add(row);
        }
        return colorsArray;
    }
}


