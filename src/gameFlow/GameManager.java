package gameFlow;

import exception.IllegalUserInputException;
import grid.startingTemplates.StartingTemplate;
import player.Player;

import java.util.List;

public class GameManager implements Subject {

    private List<GridObserver> observers;
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
    public void manageGame() throws IllegalUserInputException {

        while(true){ // Be aware of the endless loop!!!

            turn.playerTurn();
            nextPlayersTurn();

        }

    }
    public void startGame(List<Player> players, int height, int width, StartingTemplate template) {
        turn = new Turn(players.get(currentIndex));
        turn.configurateStart(template,players, height, width);
    }




    @Override
    public void registerObserver(GridObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(GridObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(GridObserver observer: observers){
            observer.update(cellsAlivePlayer1,cellsAlivePlayer2,generationPlayer1,generationPlayer2);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }
    public void setMeasurements(){
        //todo here the stats of the Grid should be calculated after each turn

        measurementsChanged();
    }
}
