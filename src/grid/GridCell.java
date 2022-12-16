package grid;

public class GridCell {

    private boolean isOccupied;
    private String playerId;
    //todo flyweight



    public GridCell(){
        isOccupied=false;
    }
    public GridCell(String playerId){
        this.playerId=playerId;
        isOccupied=true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    public String  getPlayerId(){
        assert playerId!=null;
        return playerId;
    }
    public void place(String playerId){
        isOccupied=true;
        this.playerId=playerId;
    }
    public void remove (String playerId){
        isOccupied=false;

    }

}
