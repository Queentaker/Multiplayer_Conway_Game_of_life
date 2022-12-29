package grid.startingTemplates;

import grid.Grid;
import grid.GridCellFactory;
import player.PlayersSignature;

import java.util.List;

public abstract class Template {
    protected final GridCellFactory factory=GridCellFactory.getInstance();
    protected int templateSize;
    protected int getMiddleRow(Grid grid){
        return grid.getGridHeight()/2;
    }
    protected int getMiddleColum(Grid grid){
        return grid.getGridWidth()/2;
    }


    protected int getXStartingPosition(Grid grid){
        return getMiddleRow(grid)-templateSize/2;
    }
    protected int getYStartingPosition(Grid grid){
        return getMiddleColum(grid)-templateSize/2;
    }


    public void addTemplate( Grid grid,List<PlayersSignature> signatures){
        List<TemplatePosition> positions= List.of(TemplatePosition.values());
        assert signatures.size()<=positions.size();
        int i=0;

        while (i<signatures.size()){
            TemplatePosition position=positions.get(i);
            int x=position.ARow+getXStartingPosition(grid);
            int y=position.BColum+getYStartingPosition(grid);
            addCustomTemplate(x,y,grid,signatures.get(i));
            i++;
        }

    }
    protected abstract void addCustomTemplate(int x,int y,Grid grid, PlayersSignature signature);
    //make sure that it is the same and fair
}
