package grid.startingTemplates;

import java.util.ArrayList;
import java.util.List;

import static enums.Constants.dist;

public enum TemplatePosition {
    leftMiddle(-dist.constant,0),
    rightMiddle(dist.constant,0),
    leftTop(-dist.constant,dist.constant),
    rightTop(dist.constant,dist.constant);

    public final int XPosition;
    public final int YPosition;

    TemplatePosition(int XPosition, int YPosition){
        this.XPosition=XPosition;
        this.YPosition=YPosition;
    }
    public List<TemplatePosition> getPositions(){
        List<TemplatePosition> positions=new ArrayList<>();
        for (TemplatePosition position:TemplatePosition.values()){
            positions.add(position);
        }
        return positions;
    }
}
