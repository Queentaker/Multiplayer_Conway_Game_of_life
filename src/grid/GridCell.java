package grid;

public class GridCell {
    private boolean isOccupied;
    private int playerId;


    public GridCell(){
        isOccupied=false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    public int getPlayerId(){
        return playerId;
    }
    public void place(int playerId){
        isOccupied=true;
        this.playerId=playerId;
    }
    public void remove (int playerId){
        isOccupied=false;
        this.playerId=0;
    }

}
