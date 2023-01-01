package grid;

import enums.GameColor;
import player.PlayersSignature;

import java.awt.*;

public class GridCell {

    private final boolean occupied;
    private PlayersSignature playersSignature;
    private final Color color;

    public GridCell(){
        this.color= GameColor.EmptyColor.color;
        occupied=false;
    }
    public GridCell(PlayersSignature playersSignature){
        this.playersSignature = playersSignature;
        this.color=playersSignature.getPlayerColor();
        occupied=true;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public PlayersSignature getPlayersSignature(){
        assert playersSignature !=null;
        return playersSignature;
    }

    public Color getGridCellColor(){
        return color;
    }
}
