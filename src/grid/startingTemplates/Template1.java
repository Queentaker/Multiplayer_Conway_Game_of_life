package grid.startingTemplates;

import grid.Grid;
import player.PlayersSignature;

public class Template1 extends Template {
    Template1(){
        this.templateSize=3;
    }

    @Override
    protected void addCustomTemplate(int x, int y, Grid grid, PlayersSignature signature) {
        grid.setGridCell(x+1,y,factory.getGridCell(signature));
        for (int i=1;i<templateSize;i++){
            for (int j=1;j<templateSize;j++){
                grid.setGridCell(x+i,y+j,factory.getGridCell(signature));
            }
        }

    }
}

