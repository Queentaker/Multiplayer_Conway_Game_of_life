package grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    //fleightweight still needs to be implemented
    private List<List<GridCell>> grid;
    private final int gridSize;
    private void createGrid (){
        GridCellFactory gridCellFactory=GridCellFactory.getInstance();

        for (int i=0;i<gridSize;i++){
            List<GridCell> row=new ArrayList<GridCell>();
            for (int j=0;j<gridSize;j++){
                row.add(gridCellFactory.getEmptyGridCell());
            }
            grid.add(row);
        }
    }
    public void setGridCell(int x,int y, GridCell gridCell){
        List<GridCell> row=grid.get(x);
        row.set(y,gridCell);
    }
    public GridCell getGridCell(int x,int y){
        return grid.get(x).get(y);
    }

    public int getGridSize() {
        return gridSize;
    }

    public Grid(int gridSize){
        this.gridSize=gridSize;
        createGrid();
    }

    //grid constructer so that one can easily create a copy of the grid;
    public Grid(Grid anotherGrid){
        this.gridSize=anotherGrid.gridSize;
        this.grid=anotherGrid.grid;
    }
}