package grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    //fleightweight still needs to be implemented
    private List<List<GridCell>> grid;
    private void createGrid (int gridSize){
        for (int i=0;i<gridSize;i++){
            List<GridCell> row=new ArrayList<GridCell>();
            for (int j=0;j<gridSize;j++){
                GridCell gridCell=new GridCell();
                row.add(gridCell);
            }
        }

    }
    public Grid(int gridSize){
        createGrid(gridSize);
    }

    //grid constructer so that one can easily create a copy of another grid;
    public Grid(Grid anotherGrid){
        this.grid=anotherGrid.grid;
    }
}