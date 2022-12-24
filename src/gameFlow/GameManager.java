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

    private GameManager(List<Player> players){
        assert players != null;
        this.players = players;
        currentIndex = 0;
    }
    private void nextPlayersTurn(){
        if (currentIndex++==players.size()){
            currentIndex=0;
        }
        else {
            currentIndex++;
        }
    }
    //would it be smarter to have an empty Turn-construcotr and give the instance of player to the playerTurn??
    private void manageGame() throws IllegalUserInputException {
        while(true){ // Be aware of the endless looop!!!
            turn = new Turn(players.get(currentIndex));
            turn.playerTurn();
            nextPlayersTurn();

        }

    }
}
