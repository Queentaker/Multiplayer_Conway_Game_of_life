package grid;

import player.PlayersSignature;

import java.awt.*;

public class GridCell {

    private final boolean occupied;
    private PlayersSignature playersSignature;

    public GridCell(){
        occupied=false;
    }
    public GridCell(PlayersSignature playersSignature){
        this.playersSignature = playersSignature;
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
        // empty gridCell
        if (!isOccupied()){
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
