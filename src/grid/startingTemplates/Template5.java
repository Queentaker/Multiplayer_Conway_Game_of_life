package grid.startingTemplates;

import gameFlow.GameManager;
import grid.Grid;
import grid.GridCellFactory;
import player.PlayersSignature;

public class Template5 extends Template {

    public Template5(){
        this.templateSize=5;
    }

    @Override
    protected void addCustomTemplate(int x, int y, Grid grid, PlayersSignature signature) {
        for(int i = 0; i<templateSize; i++){
            for(int j = 0; j<templateSize; j++){
                if((i+j)%3!=0){
                    grid.setGridCell(x+i,y+j, factory.getGridCell(signature));
                }
            }
        }
    }
}
