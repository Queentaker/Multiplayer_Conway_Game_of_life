package gameFlow.states;


import exception.IllegalUserInputException;
import grid.CoordinatesTuple;
import gameFlow.GameManager;
import gameFlow.Turn;
import grid.Grid;

public class AddCell implements TurnState {
    private Grid aGrid;
    Turn aTurn;
    CoordinatesTuple coordinatesTuple;
    public AddCell(Turn aTurn, Grid aGrid){
        this.aTurn = aTurn;
        this.aGrid = aGrid;
    }
    @Override
    public void next() throws IllegalUserInputException {
        coordinatesTuple =aTurn.getCoordinates();
        aGrid.placeGridCell(coordinatesTuple.aCoordinate, coordinatesTuple.bCoordinate, aTurn.getCurrentPlayersSignature());
        aTurn.addGeneration();
        aTurn.setEvolveNextGen();
        GameManager.getInstance().nextPlayersTurn();
        GameManager.getInstance().setMeasurements("remove");
    }
}
