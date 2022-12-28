package gameFlow.states;


import exception.IllegalUserInputException;
import gameFlow.CoordinatesTuple;
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
        aGrid.removeGridCell(aTurn.getCurrentPlayersSignature(), coordinatesTuple.xCoordinate, coordinatesTuple.yCoordinate);
        aTurn.addGeneration();
        aTurn.setEvolveNextGen();
        GameManager.getInstance().setMeasurements();
        aTurn.setCurrentState(new AddCell(aTurn, aGrid));
    }
}
