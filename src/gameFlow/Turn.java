package gameFlow;

import GUI.Frame;
import GUI.playing.playingElements.PlayerInformationPanel;
import exception.IllegalUserInputException;
import grid.EvolveNextGen;
import grid.Grid;
import grid.GridCellFactory;
import grid.startingTemplates.StartingTemplate;
import player.Player;
import player.PlayersSignature;

import javax.swing.*;
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

    public void playerTurn(CoordinatesTuple coordinatesTuple) throws IllegalUserInputException {


        this.coordinates = coordinatesTuple;
        if(!grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getPlayersSignature().equals(getCurrentPlayersSignature())&& !grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getGridCellColor().equals(Color.WHITE)){
            grid.setGridCell(coordinates.xCoordinate, coordinates.yCoordinate, GridCellFactory.getInstance().getEmptyGridCell());
        }
        else{
            throw new IllegalUserInputException("You must choose an opponents cell");
        }
        if (grid.getGridCell(coordinates.xCoordinate, coordinates.yCoordinate).getGridCellColor()==Color.WHITE){
            grid.setGridCell(coordinates.xCoordinate, coordinates.yCoordinate, GridCellFactory.getInstance().getGridCell(currentPlayer));
        }
        else{
            throw new IllegalUserInputException("You must choose an empty cell");
        }
        this.generation++;
        evolveNextGen.evolve(grid);
    }



    public PlayersSignature getCurrentPlayersSignature() {
        return currentPlayer;
    }

    public void configurateStart(StartingTemplate template, List<Player> players, int heigth, int with){
        grid = new Grid(heigth,with);
        int middleHorizont = grid.getGridWidth()/2;
        int startVert = (grid.getGridHeight()/2)-2;

        for(Player p: players){
            template.returnStartingGridPattern(p);
        }



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

    //checks for all cells alive from a player
    public int getCellsAlivePlayer(PlayersSignature playersSignature){
        int cellsAlivePlayer=0;
        for(int x = 0; x < grid.getGridWidth(); x++){
            for(int y = 0; y < grid.getGridHeight(); y++){
                if(grid.getGridCell(x,y).isOccupied() && grid.getGridCell(x,y).getPlayersSignature()==playersSignature){
                    cellsAlivePlayer++;
                }
            }
        }
        return cellsAlivePlayer;
    }

}