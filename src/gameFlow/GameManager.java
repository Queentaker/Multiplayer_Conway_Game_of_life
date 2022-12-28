package gameFlow;

import GUI.GameFrame;
import GUI.FrameObserver;
import grid.Grid;
import player.Player;

import java.util.List;

public class GameManager implements Subject {

    private List<FrameObserver> observers;
    private int cellsAlivePlayer1;
    private int cellsAlivePlayer2;
    private int generationPlayer1;
    private int generationPlayer2;
    private static GameManager uniqueInstance;

    private final List<Player> players;
    private int currentIndex;
    private Turn turn;

    private final GameFrame frame;

    public static synchronized GameManager getInstance(List<Player> players, Grid grid, GameFrame frame){
        if(uniqueInstance==null){
            uniqueInstance = new GameManager(players, grid, frame);
        }
        return uniqueInstance;
    }

    public static GameManager getInstance(){
        assert uniqueInstance!=null;
        return uniqueInstance;
    }

    private GameManager(List<Player> players, Grid grid,  GameFrame frame){
        assert players != null;
        this.players = players;
        currentIndex = 0;
        turn = new Turn(players.get(currentIndex), grid);
        this.frame = frame;
    }
    public void nextPlayersTurn(){
        if (currentIndex++==players.size()){
            currentIndex=0;
        }
        else {
            currentIndex++;
        }
    }
    //would it be smarter to have an empty Turn-constructor and give the instance of player to the playerTurn??

    public void sendCoordinates(CoordinatesTuple coordinatesTuple) {
        turn.setCoordinates(coordinatesTuple);
    }


    @Override
    public void registerObserver(FrameObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(FrameObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserversGeneral() {
        for(FrameObserver observer: observers){
            observer.updateGeneral(cellsAlivePlayer1, cellsAlivePlayer2, generationPlayer1, "I'm a Message",
                    turn.getColors());
        }
    }

    @Override
    public void notifyObserversMessage() {
        for(FrameObserver observer: observers){
            observer.updateMessage("I'm another Message");
        }
    }

    public void measurementsChanged(){
        notifyObserversGeneral();
    }
    public void setMeasurements(){
        //todo here the stats of the Grid should be calculated after each turn
        if(turn.getCurrentPlayersSignature()==players.get(0)){
            cellsAlivePlayer1 = turn.getCellsAlivePlayer(turn.getCurrentPlayersSignature());
            generationPlayer1++;
        }
        else{
            cellsAlivePlayer2 = turn.getCellsAlivePlayer(turn.getCurrentPlayersSignature());
            generationPlayer2++;
        }
        measurementsChanged();
    }
}
