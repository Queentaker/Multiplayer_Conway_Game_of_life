package grid.startingTemplates;

import grid.Grid;
import player.PlayersSignature;

public class Template2 extends Template {
    Template2(){
        this.templateSize=5;
    }

    @Override
    protected void addCustomTemplate(int x, int y, Grid grid, PlayersSignature signature) {
        for (int i=0;i<templateSize;i++){
            for (int j=0;j<templateSize;j++){
                if (middleEdgeRow(i,j) || secondColum(i,j)){
                    grid.setGridCell(x+i,y+j,factory.getGridCell(signature));
                }
            }
        }
    }
    private boolean middleEdgeRow(int i,int j){
        return j==2 && (i==0||i==4);
    }
    private boolean secondColum(int i,int j){
        if (i!=0&&i!=4){
            return j == 1 || j == 3;
        }
        return false;
    }
}
