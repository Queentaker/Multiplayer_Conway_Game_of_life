package grid;

import player.PlayersSignature;

import java.util.*;

public class EvolveNextGen2 {

    public static void evolve(Grid grid) {
        ArrayList<Change> changes = new ArrayList<>();
        int upperBoundaryRow = grid.getGridHeight();
        int upperBoundaryColumn = grid.getGridWidth();

        for (int row = 0; row < upperBoundaryRow; row++) {
            for (int column = 0; column < upperBoundaryColumn; column++) {
                GridCell currentCell = grid.getGridCell(row, column);
                NumNeighbors currentNeighbors = amountOfNeighbors(row, column, grid);
                if (currentCell.isOccupied()) {
                    if (!doesSurvive(currentNeighbors)) {
                        changes.add(new Change(row, column, GridCellFactory.getInstance().getEmptyGridCell()));
                    }
                } else {
                    if (doesNewGrow(currentNeighbors)) {
                        changes.add(new Change(row, column, newGrown(row, column, grid)));
                    }
                }
            }
        }
        applyChanges(grid, changes);
    }

    private static void applyChanges(Grid grid, ArrayList<Change> changes) {
        for (Change aChange : changes) {
            grid.setGridCell(aChange.row, aChange.column, aChange.newGridCell);
        }
    }

    private static NumNeighbors amountOfNeighbors(int row, int column, Grid grid) {
        return NumNeighbors.getEnum(getNeighbors(row, column, grid).size());
    }

    private static boolean doesSurvive(NumNeighbors aliveNeighbors) {
        return aliveNeighbors == NumNeighbors.Two || aliveNeighbors == NumNeighbors.Three;
    }

    private static boolean doesNewGrow(NumNeighbors aliveNeighbors) {
        return aliveNeighbors == NumNeighbors.Three;
    }

    private static GridCell newGrown(int row, int column, Grid grid) {
        ArrayList<GridCell> neighbors = getNeighbors(row, column, grid);
        assert neighbors.size() == 3;
        if (neighbors.get(0).getPlayersSignature() == neighbors.get(1).getPlayersSignature() ||
                neighbors.get(0).getPlayersSignature() == neighbors.get(2).getPlayersSignature()) {
            return neighbors.get(0);
        } else if (neighbors.get(1).getPlayersSignature() == neighbors.get(2).getPlayersSignature()) {
            return neighbors.get(1);
        }
        assert false;
        return neighbors.get(0);
    }

    private static ArrayList<GridCell> getNeighbors(int row, int column, Grid grid) {
        ArrayList<GridCell> neighbors = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(i == 0 & j == 0)) {
                    if (doesCoordinateExist2(row + i, column + j, grid)) {
                        GridCell aCell = grid.getGridCell(row + i, column + j);
                        if (aCell.isOccupied()) {
                            neighbors.add(grid.getGridCell(row + i, column + j));
                        }
                    }
                }
            }
        }
        return neighbors;
    }

    private static boolean doesCoordinateExist2(int row, int column, Grid grid) {
        int upperBoundaryRow = grid.getGridHeight();
        int upperBoundaryColumn = grid.getGridWidth();
        return (row >= 0 && row < upperBoundaryRow) && (column >= 0 && column < upperBoundaryColumn);
    }
}