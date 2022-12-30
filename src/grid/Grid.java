package grid;

import exception.IllegalUserInputException;
import gameFlow.GameManager;
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
    String soundName = "src/GUI/sounds/clickerrorsound.wav";
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
        for (int a=0;a<gridHeight;a++){
            ArrayList<GridCell> row=new ArrayList<GridCell>();
            for (int b=0;b<gridWidth;b++){
                row.add(anotherGrid.getGridCell(a,b));
            }
            copy.add(row);
        }
        return copy;
    }

    public void evolve(){
        evolveNextGen.evolve(this);
    }

    public void setGridCell(int a,int b, GridCell gridCell){
        List<GridCell> row=grid.get(a);
        row.set(b,gridCell);
    }
    public GridCell getGridCell(int a,int b){
        return grid.get(a).get(b);
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    @Override
    public void placeGridCell(int a, int b, PlayersSignature playersSignature) throws IllegalUserInputException {
        assert a>=0 && a<gridHeight;
        assert b>=0 && b<gridWidth;
        String currentPlayer = playersSignature.getPlayerName();
        if (getGridCell(a,b).isOccupied()){
            GameManager.getInstance().playSound(soundName);
            throw new IllegalUserInputException(currentPlayer +", you can't add a cell to an already occupied one!");
        }
        setGridCell(a,b, cellFactory.getGridCell(playersSignature));
    }

    @Override
    public void removeGridCell(int a, int b, PlayersSignature playersSignature) throws IllegalUserInputException{
        assert a>=0 && a<gridHeight;
        assert b>=0 && b<gridWidth;
        String currentPlayer = playersSignature.getPlayerName();
        if (!getGridCell(a,b).isOccupied()){
            GameManager.getInstance().playSound(soundName);
            throw new IllegalUserInputException(currentPlayer + ", you can't remove an empty cell!");
        }
        if (getGridCell(a, b).getPlayersSignature().getPlayerId().equals(playersSignature.getPlayerId())){
            GameManager.getInstance().playSound(soundName);
            throw new IllegalUserInputException(currentPlayer + ", you can't remove your own cell!");
        }
        setGridCell(a,b, cellFactory.getEmptyGridCell());
    }

    //checks for all cells alive from a player
    //shouldnt it be x in range gridHeight and y in range grid
    public int cellsAlivePlayer(PlayersSignature playersSignature){
        int cellsAlivePlayer=0;
        for(int a = 0; a < gridHeight; a++){
            for(int b = 0; b < gridWidth; b++){
                GridCell currentCell = getGridCell(a, b);
                if (currentCell.isOccupied()) {
                    if(getGridCell(a,b).getPlayersSignature()==playersSignature){
                        cellsAlivePlayer++;
                    }
                }
            }
        }
        return cellsAlivePlayer;
    }
    //todo private Map<PlayersSignature,Integer> getPlayersAliveCell {}

    public ArrayList<ArrayList<Color>> getColors(){
        ArrayList<ArrayList<Color>> colorsArray = new ArrayList<ArrayList<Color>>();
        for (int a=0;a<gridHeight;a++){
            ArrayList<Color> row=new ArrayList<Color>();
            for (int b=0;b<gridWidth;b++){
                row.add(getGridCell(a,b).getGridCellColor());
            }
            colorsArray.add(row);
        }
        return colorsArray;
    }
}