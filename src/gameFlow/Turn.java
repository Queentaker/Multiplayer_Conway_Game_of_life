package gameFlow;

import exception.IllegalUserInputException;
import grid.EvolveNextGen;
import grid.Grid;
import grid.GridCellFactory;
import grid.startingTemplates.StartingTemplate;
import player.Player;
import player.PlayersSignature;

import java.awt.*;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

public class Turn {


    private Player currentPlayer;
    private Grid grid;
    private CoordinatesTuple coordinates;
    private EvolveNextGen evolveNextGen;
    private int generation=0;

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
        this.generation++;
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
    public void configurateStart(StartingTemplate template, List<Player> players, int heigth, int with){
        grid = new Grid(heigth,with);
        template.addStartingGridPatterns(grid,getPlayersSignature(players));


    }
    private List<PlayersSignature> getPlayersSignature(List<Player> players){
        List<PlayersSignature> signatures=new ArrayList<>();
        for (Player player: players){
            signatures.add(player);
        }
        return signatures;
    }
    public String getName(){
        return currentPlayer.getPlayerName();
    }

}