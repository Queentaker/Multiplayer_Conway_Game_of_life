package grid.startingTemplates;

import grid.Grid;
import grid.GridCellFactory;
import player.PlayersSignature;

public class Template5 extends Template {

    public Template5(){
        this.templateSize=6;
    }

    @Override
    protected void addCustomTemplate(int x, int y, Grid grid, PlayersSignature signature) {
        for(int i = 1; i<templateSize+1; i++){
            for(int j = 1; j<templateSize+1; i++){
                if((i+j-2)*3!=0){
                    grid.setGridCell(i+x-1,y+j-1, GridCellFactory.getInstance().getGridCell(signature));
                }
            }
        }
    }
}
