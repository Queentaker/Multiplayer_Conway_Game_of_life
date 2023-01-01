package gameFlow.states;

import exception.IllegalUserInputException;
import grid.CoordinatesTuple;
import gameFlow.GameManager;
import gameFlow.Turn;
import grid.Grid;

public class RemoveCell implements TurnState{
    private final Grid aGrid;
    Turn aTurn;
    CoordinatesTuple coordinatesTuple;

    public RemoveCell(Turn aTurn, Grid aGrid){
        this.aTurn = aTurn;
        this.aGrid = aGrid;
    }

    @Override
    public void next() throws IllegalUserInputException {
        coordinatesTuple =aTurn.getCoordinates();
        aGrid.removeGridCell(coordinatesTuple.aCoordinate, coordinatesTuple.bCoordinate, aTurn.getCurrentPlayersSignature());
        GameManager.getInstance().setMeasurements("add");
        aTurn.setCurrentState(new AddCell(aTurn, aGrid));
    }
}
