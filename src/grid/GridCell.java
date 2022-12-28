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
    //needs a better name but with function one can get the playersID
    public PlayersSignature getPlayersSignature(){
        assert playersSignature !=null;
        return playersSignature;
    }

    public Color getGridCellColor(){
        return color;
    }
    /*public void place(String playerId){
        isOccupied=true;
        this.playerId=playerId;
    }
    public void remove (String playerId){
        isOccupied=false;

    }*/

}
