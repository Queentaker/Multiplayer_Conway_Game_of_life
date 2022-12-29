package gameFlow.states;


import exception.IllegalUserInputException;
import grid.CoordinatesTuple;
import gameFlow.GameManager;
import gameFlow.Turn;
import grid.Grid;


public class RemoveCell implements TurnState{
    private  Grid aGrid;
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
        aTurn.addGeneration();
        GameManager.getInstance().setMeasurements("Add");
        aTurn.setCurrentState(new AddCell(aTurn, aGrid));
    }
}
