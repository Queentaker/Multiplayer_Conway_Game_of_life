package gameFlow;

import exception.IllegalUserInputException;
import player.Player;

import java.util.List;

public class GameManager {

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
    public void startGame(List<CoordinatesTuple> startConfiguration, List<Player> players, int height, int width){
        turn = new Turn(players.get(currentIndex));
        turn.configurateStart(startConfiguration, players, height, width);
    }
}
