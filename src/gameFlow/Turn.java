package gameFlow;

import player.Player;
import player.PlayersSignature;

import java.util.List;

public class Turn {
    private final List<Player> players;
    private int currentIndex;

    public Turn (List<Player> players){
        assert players!=null;
        this.players=players;
        currentIndex=0;
    }
    public PlayersSignature getCurrentPlayersSignature(){
        return players.get(currentIndex);
    }

    public Player getCurrentPlayer(){
        return players.get(currentIndex);
    }
    public void nextPlayersTurn(){
        if (currentIndex++==players.size()){
            currentIndex=0;
        }
        else {
            currentIndex++;
        }
    }

}
