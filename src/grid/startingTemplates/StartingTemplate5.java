package grid.startingTemplates;

import grid.Grid;
import grid.GridCellFactory;
import player.Player;

public class StartingTemplate5 implements StartingTemplate {
    Grid template;
    @Override
    public Grid returnStartingGridPattern (Player player){
        template = new Grid(5,5);
        for(int i = 1; i<6; i++){
            for(int j = 1; j<6; i++){
                if((i+j-2)%3==0){
                    template.setGridCell(i,j, GridCellFactory.getInstance().getGridCell(player));
                }else{
                    template.setGridCell(i,j,GridCellFactory.getInstance().getEmptyGridCell());
                }
            }
        }
        return template;
    }
}
}
