package grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    //fleightweight
    private List<List<GridCell>> grid;
    private void createGrid (){
        for (int i=0;i<100;i++){
            List<GridCell> row=new ArrayList<GridCell>();
            for (int j=0;j<100;j++){
                GridCell gridCell=new GridCell();
                row.add(gridCell);

            }
        }

    }
    public Grid(){
        createGrid();
    }
}