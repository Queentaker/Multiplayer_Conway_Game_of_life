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

    protected int getAStartingPosition(Grid grid){
        return getMiddleRow(grid)-templateSize/2;
    }

    protected int getBStartingPosition(Grid grid){
        return getMiddleColum(grid)-templateSize/2;
    }

    public void addTemplate( Grid grid,List<PlayersSignature> signatures){
        List<TemplatePosition> positions= List.of(TemplatePosition.values());
        assert signatures.size()<=positions.size();
        int i=0;
        while (i<signatures.size()){
            TemplatePosition position=positions.get(i);
            int a=position.ARow+ getAStartingPosition(grid);
            int b=position.BColum+ getBStartingPosition(grid);
            addCustomTemplate(a,b,grid,signatures.get(i));
            i++;
        }
    }

    protected abstract void addCustomTemplate(int a, int b, Grid grid, PlayersSignature signature);
}
