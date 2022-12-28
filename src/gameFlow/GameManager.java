package gameFlow;

import GUI.FrameObserver;
import exception.IllegalUserInputException;
import grid.CoordinatesTuple;
import grid.Grid;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements Subject {

    private List<FrameObserver> observers;
    private int cellsAlivePlayer1;
    private int cellsAlivePlayer2;
    private int generation;
    private static GameManager uniqueInstance;

    private final List<Player> players;
    private int currentIndex;
    private Turn turn;


    public static synchronized GameManager getInstance(List<Player> players, Grid grid){
        if(uniqueInstance==null){
            uniqueInstance = new GameManager(players, grid);
        }
        return uniqueInstance;
    }

    public static GameManager getInstance(){
        assert uniqueInstance!=null;
        return uniqueInstance;
    }

    private GameManager(List<Player> players, Grid grid){
        observers = new ArrayList<>();
        assert players != null;
        this.players = players;
        currentIndex = 0;
        turn = new Turn(players.get(currentIndex), grid);
    }

    public void nextPlayersTurn(){
        if (currentIndex++==players.size()){
            currentIndex=0;
        }
        else {
            currentIndex++;
        }
    }

    public void receiveCoordinates(CoordinatesTuple coordinatesTuple) {
        System.out.println("made it here2");
        String message = "I can tell the Player what to do, huiuiuiuiui...";
        turn.setCoordinates(coordinatesTuple);
        try {
            turn.execute();
        } catch (IllegalUserInputException e) {
            notifyObserversMessage(e.getMessage());
        }
        notifyObserversGeneral(message);
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
    public void notifyObserversGeneral(String message) {
        for(FrameObserver observer: observers){
            observer.updateGeneral(cellsAlivePlayer1, cellsAlivePlayer2, generation, message,
                    turn.getColors());
        }
    }

    @Override
    public void notifyObserversMessage(String message) {
        for(FrameObserver observer: observers){
            observer.updateMessage("I'm another Message");
        }
    }

    public void setMeasurements(){
        cellsAlivePlayer1 = turn.getCellsAlivePlayer(players.get(0));
        cellsAlivePlayer2 = turn.getCellsAlivePlayer(players.get(1));
        generation = turn.getGeneration();
    }
}
