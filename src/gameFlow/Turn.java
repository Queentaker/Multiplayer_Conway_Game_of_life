package gameFlow;

import exception.IllegalUserInputException;
import grid.EvolveNextGen;
import grid.Grid;
import grid.GridCellFactory;
import player.Player;
import player.PlayersSignature;

import java.awt.*;
import java.util.List;

public class Turn {


    private Player currentPlayer;
    private Grid grid;
    private CoordinatesTuple coordinates;
    private EvolveNextGen evolveNextGen;

    public Turn(Player currentPlayer) {
        assert currentPlayer != null;
        this.currentPlayer = currentPlayer;
    }

    public void playerTurn() throws IllegalUserInputException {

        coordinates = getCoordinates();
        if(!grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getPlayersSignature().equals(getCurrentPlayersSignature())&& !grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getGridCellColor().equals(Color.WHITE)){
            grid.setGridCell(coordinates.xCoordinate, coordinates.yCoordinate, GridCellFactory.getInstance().getEmptyGridCell());//I want to set a white player cell
        }
        else{
            throw new IllegalUserInputException("You must choose an opponents cell");
        }
        coordinates = getCoordinates();
        if (grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getGridCellColor()==Color.WHITE){
            grid.setGridCell(coordinates.xCoordinate, coordinates.yCoordinate, GridCellFactory.getInstance().getGridCell(currentPlayer)); // I want to set a curretns player cell
        }
        else{
            throw new IllegalUserInputException("You must choose an empty cell");
        }
        evolveNextGen.evolve(grid);
    }

    private CoordinatesTuple getCoordinates(){
        //This lines represent the input from the GUI until I receive the real one...
        int xCoordinate = 1;
        int yCoordinate = 1;
        //I assume, that it only can be called with valid coordinates...
        //Here the input from the GUI comes in...
        return new CoordinatesTuple(xCoordinate, yCoordinate);
    }

    public PlayersSignature getCurrentPlayersSignature() {
        return currentPlayer;
    }
    public void configurateStart(List<CoordinatesTuple>startConfiguration, List<Player> players, int heigth, int with){
        grid = new Grid(heigth,with);
        for (int i = 0; i< players.size()-1; i++){
            for (int j = 0; j< startConfiguration.size()-1; j++){
                grid.setGridCell(startConfiguration.get(j).xCoordinate, startConfiguration.get(j).yCoordinate, GridCellFactory.getInstance().getGridCell(players.get(i)));
            }
        }
    }
    public String getName(){
        return currentPlayer.getPlayerName();
    }

}