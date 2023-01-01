package grid.startingTemplates;

import grid.Grid;
import player.PlayersSignature;

public class Template1 extends Template {
    Template1(){
        this.templateSize=3;
    }

    @Override
    protected void addCustomTemplate(int a, int b, Grid grid, PlayersSignature signature) {
        grid.setGridCell(a +1, b,factory.getGridCell(signature));
        for (int i=1;i<templateSize;i++){
            for (int j=1;j<templateSize;j++){
                grid.setGridCell(a +i, b +j,factory.getGridCell(signature));
            }
        }
    }
}

