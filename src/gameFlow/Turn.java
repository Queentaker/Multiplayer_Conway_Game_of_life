package gameFlow;

import exception.IllegalUserInputException;
import gameFlow.states.RemoveCell;
import gameFlow.states.TurnState;
import grid.CoordinatesTuple;
import grid.EvolveNextGen;
import grid.Grid;
import player.Player;
import player.PlayersSignature;

import java.awt.*;
import java.util.ArrayList;

public class Turn {
    private Player currentPlayer;
    private final Grid grid;
    private CoordinatesTuple coordinates;
    private int generation;
    private TurnState currentState;

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
    public void execute() throws IllegalUserInputException {
        currentState.next();
    }

    public void addGeneration(){
        this.generation++;
    }

    public void setEvolveNextGen(){
        EvolveNextGen.evolve(grid);
    }
    public void setCoordinates(CoordinatesTuple coordinates) {
        this.coordinates = coordinates;
    }

    public CoordinatesTuple getCoordinates() {
        return coordinates;
    }

    public PlayersSignature getCurrentPlayersSignature() {
        return currentPlayer;
    }

    public String getName(){
        return currentPlayer.getPlayerName();
    }

    public int getCellsAlivePlayer(PlayersSignature playersSignature){
        return grid.cellsAlivePlayer(playersSignature);
    }

    public ArrayList<ArrayList<Color>> getColors() {
        return grid.getColors();
    }

    public int getGeneration() {
        return generation;
    }

    public void nextPlayerTurn(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}