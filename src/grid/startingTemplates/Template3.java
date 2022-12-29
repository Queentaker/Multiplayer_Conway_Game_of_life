package grid.startingTemplates;

import grid.Grid;
import player.PlayersSignature;

public class Template3 extends Template {


    public Template3() {
        this.templateSize=5;
    }

    @Override
    protected void addCustomTemplate(int x, int y, Grid grid, PlayersSignature signature) {
        for (int i=0;i<templateSize; i++){
            for (int j=0;j<templateSize;j++){
                if (!((i+j)%2==0)){
                    assert !grid.getGridCell(x+i,y+j).isOccupied();
                    grid.setGridCell(x+i,y+j,factory.getGridCell(signature));
                }
            }
        }
    }
}
