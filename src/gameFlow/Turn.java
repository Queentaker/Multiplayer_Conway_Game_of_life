package gameFlow;

import exception.IllegalUserInputException;
import gameFlow.states.RemoveCell;
import gameFlow.states.TurnState;
import grid.EvolveNextGen;
import grid.Grid;
import grid.GridCellFactory;
import grid.startingTemplates.StartingTemplate;
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
    private int generation=0;
    private TurnState currentState = new RemoveCell(this, grid);
    public void setCurrentState(TurnState currentState){
        this.currentState=currentState;
        this.grid = grid;
    }
    public Turn(Player currentPlayer) {
        assert currentPlayer != null;
        this.currentPlayer = currentPlayer;
    }
    public void execute() throws IllegalUserInputException {currentState.next();}

    public void addGeneration(){
        this.generation++;
    }
    public void setEvolveNextGen(){
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
    public CoordinatesTuple getCoordinates(){return coordinates;}
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