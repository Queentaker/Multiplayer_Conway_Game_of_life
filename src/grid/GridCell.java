package grid;

import player.PlayersSignature;

public class GridCell {

    private final boolean isOccupied;
    private PlayersSignature playersSignature;
    //todo flyweight



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
    public String getPlayersSignatureId(){
        assert playersSignature !=null;
        return playersSignature.getPlayerId();
    }
    public String displayGrid(){
        // empty gridcell
        if (playersSignature==null){
            return "";
        }
        return playersSignature.getPlayerSymbol();
    }
    /*public void place(String playerId){
        isOccupied=true;
        this.playerId=playerId;
    }
    public void remove (String playerId){
        isOccupied=false;

    }*/

}
