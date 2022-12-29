package grid.startingTemplates;

import grid.Grid;
import player.PlayersSignature;

public class Template6 extends Template {

    public Template6(){
        this.templateSize=5;
    }

    @Override
    protected void addCustomTemplate(int x, int y, Grid grid, PlayersSignature signature) {
        for(int i = 0; i<templateSize; i++){
            for(int j = 0; j<templateSize; j++){
                if(i == 0 || i == templateSize-1 || j == 0 || j == templateSize-1){
                    grid.setGridCell(x+i,y+j, factory.getGridCell(signature));
                }
            }
        }
    }
}
