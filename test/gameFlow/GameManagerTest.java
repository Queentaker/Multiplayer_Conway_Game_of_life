package gameFlow;

import org.junit.jupiter.api.Test;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManagerTest {
    List<Player> players = new ArrayList<>();
    List<CoordinatesTuple> startConfiguration= new ArrayList<>();
    GameManager gameManager = new GameManager(players);
    @Test
    public void nextPlayersTurnTest(){
        gameManager.nextPlayersTurn();
        // how to get the currentIndex
    }
/*
    @Test
    public void startGameTest(){
        gameManager.startGame(startConfiguration, players, 3, 3);
        // what could I get??
    }
*/

}
