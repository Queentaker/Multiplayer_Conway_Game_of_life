package grid;

import player.PlayersSignature;

import java.awt.*;

public class GridCell {

    private final boolean isOccupied;
    private PlayersSignature playersSignature;

    public GridCell(){
        isOccupied=false;
    }
    public GridCell(PlayersSignature playersSignature){
        this.playersSignature = playersSignature;
        isOccupied=true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    //needs a better name but with function one can get the playersID
    public PlayersSignature getPlayersSignature(){
        assert playersSignature !=null;
        return playersSignature;
    }

    public Color getGridCellColor(){
        // empty gridcell
        if (playersSignature==null){
            return Color.WHITE;
        }
        return playersSignature.getPlayerColor();
    }
    /*public void place(String playerId){
        isOccupied=true;
        this.playerId=playerId;
    }
    public void remove (String playerId){
        isOccupied=false;

    }*/

}
