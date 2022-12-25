package grid;

import exception.IllegalUserInputException;
import player.PlayersSignature;

import java.util.ArrayList;
import java.util.List;

public class Grid implements AddRemoveGridCell, Subject {
    //flyweight still needs to be implemented
    private List<GridObserver> observers;
    private int cellsAlivePlayer1;
    private int cellsAlivePlayer2;
    private int generationPlayer1;
    private int generationPlayer2;
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

    @Override
    public void registerObserver(GridObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(GridObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(GridObserver observer: observers){
            observer.update(cellsAlivePlayer1,cellsAlivePlayer2,generationPlayer1,generationPlayer2);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }
    public void setMeasurements(){
        //todo here the stats of the Grid should be calculated after each turn
        measurementsChanged();
    }

}