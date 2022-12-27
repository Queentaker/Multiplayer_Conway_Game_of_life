package gameFlow;

import GUI.Frame;
import GUI.FrameObserver;
import exception.IllegalUserInputException;
import grid.Grid;
import grid.startingTemplates.StartingTemplate;
import jdk.internal.org.jline.utils.Colors;
import player.Player;

import java.awt.*;
import java.util.ArrayList;
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

    public static synchronized GameManager getInstance(List<Player> players){
        if(uniqueInstance==null){
            uniqueInstance = new GameManager(players);
        }
        return uniqueInstance;
    }

    public static GameManager getInstance(){
        assert uniqueInstance!=null;
        return uniqueInstance;
    }

    GameManager(List<Player> players){
        assert players != null;
        this.players = players;
        currentIndex = 0;
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

    public void startGame(List<Player> players, int height, int width, StartingTemplate template) {
        turn = new Turn(players.get(currentIndex));
        turn.configurateStart(template,players, height, width);
    }

    public void sendCoordinates(CoordinatesTuple coordinatesTuple) throws IllegalUserInputException {
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
    public void notifyObservers() {
        for(FrameObserver observer: observers){
            ArrayList<ArrayList<Color>> colors = new ArrayList<>();
            observer.updateGeneral(cellsAlivePlayer1, cellsAlivePlayer2, generationPlayer1, "I'm a Message", colors);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
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
