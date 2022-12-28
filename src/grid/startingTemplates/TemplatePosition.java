package grid.startingTemplates;

import java.util.ArrayList;
import java.util.List;

import static enums.Constants.dist;

public enum TemplatePosition {
    leftMiddle(0,-dist.constant),
    rightMiddle(0, dist.constant),
    leftTop(-dist.constant,dist.constant),
    rightTop(dist.constant,dist.constant);

    public final int ARow;
    public final int BColum;

    TemplatePosition(int ARow, int BColum){
        this.ARow=ARow;
        this.BColum=BColum;
    }
}
