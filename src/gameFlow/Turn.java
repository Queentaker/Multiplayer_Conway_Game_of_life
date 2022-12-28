package gameFlow;

import exception.IllegalUserInputException;
import gameFlow.states.RemoveCell;
import gameFlow.states.TurnState;
import grid.EvolveNextGen;
import grid.Grid;
import grid.startingTemplates.Template;
import player.Player;
import player.PlayersSignature;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Turn {



    private Player currentPlayer;
    private Grid grid;
    private CoordinatesTuple coordinates;
    private EvolveNextGen evolveNextGen;
    private int generation;
    private TurnState currentState = new RemoveCell(this, grid);
    public void setCurrentState(TurnState currentState){
        this.currentState=currentState;
    }
    public Turn(Player currentPlayer, Grid grid) {
        assert currentPlayer != null;
        this.currentPlayer = currentPlayer;
        this.grid = grid;
        generation = 0;
        setCurrentState(new RemoveCell(this, grid));
    }
    public void execute() throws IllegalUserInputException {currentState.next();}

    public void addGeneration(){
        this.generation++;
    }
    public void setEvolveNextGen(){
        evolveNextGen.evolve(grid);
    }
    public void setCoordinates(CoordinatesTuple coordinates){this.coordinates = coordinates;}
    public CoordinatesTuple getCoordinates(){return coordinates;}

    public PlayersSignature getCurrentPlayersSignature() {
        return currentPlayer;
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

    public ArrayList<ArrayList<Color>> getColors() {
        return grid.getColors();
    }

    public int getGeneration() {
        return generation;
    }
}