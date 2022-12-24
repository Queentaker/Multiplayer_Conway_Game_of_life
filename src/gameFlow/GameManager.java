package gameFlow;

import exception.IllegalUserInputException;
import player.Player;

import java.util.List;

public class GameManager {
    private final List<Player> players;

    private int currentIndex;

    private Turn turn;

    public GameManager(List<Player> player){
        assert player != null;
        this.players = player;
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
