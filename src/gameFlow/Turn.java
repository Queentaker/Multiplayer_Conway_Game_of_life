package gameFlow;

import exception.IllegalUserInputException;
import grid.Grid;
import grid.GridCell;
import player.Player;
import player.PlayersSignature;

import java.awt.*;
import java.util.List;

public class Turn {


    private Player currentPlayer;
    private Grid grid;
    private CoordinatesTuple coordinates;

    public Turn(Player currentPlayer) {
        assert currentPlayer != null;
        this.currentPlayer = currentPlayer;
    }

    public void playerTurn() throws IllegalUserInputException {

        coordinates = getCoordinates();
        if(!grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getPlayersSignature().equals(getCurrentPlayersSignature())&& !grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getGridCellColor().equals(Color.WHITE)){
            grid.placeGridCell(currentPlayer, coordinates.xCoordinate, coordinates.yCoordinate);//I want to set a currents player cell
        }
        else{
            throw new IllegalUserInputException("You must choose an opponents cell");
        }
        coordinates = getCoordinates();
        if (grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getGridCellColor()==Color.WHITE){
            grid.placeGridCell(currentPlayer, coordinates.xCoordinate, coordinates.yCoordinate); // I want to set a currents player cell
        }
        else{
            throw new IllegalUserInputException("You must choose an empty cell");
        }
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

}