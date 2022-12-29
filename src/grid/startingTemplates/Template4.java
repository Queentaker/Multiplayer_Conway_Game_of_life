package grid.startingTemplates;

import grid.Grid;
import player.PlayersSignature;

public class Template4 extends Template {

    public Template4(){
        this.templateSize=5;
    }

    @Override
    protected void addCustomTemplate(int a, int b, Grid grid, PlayersSignature signature) {
        for (int i=0;i<templateSize;i++){
            for (int j=0;j<templateSize;j++){
                if (j%2==0){
                    grid.setGridCell(a +i, b +j,factory.getGridCell(signature));
                }
            }
        }
    }
}
