package grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    //fleightweight still needs to be implemented
    private List<List<GridCell>> grid;
    private final int gridSize;
    private void createGrid (){
        for (int i=0;i<gridSize;i++){
            List<GridCell> row=new ArrayList<GridCell>();
            for (int j=0;j<gridSize;j++){
                GridCell gridCell=new GridCell();
                row.add(gridCell);
            }
        }

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

    //grid constructer so that one can easily create a copy of another grid;
    public Grid(Grid anotherGrid){
        this.gridSize=anotherGrid.gridSize;
        this.grid=anotherGrid.grid;
    }
}