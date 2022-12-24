package gameFlow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.Player;
import player.PlayersSignature;

import java.awt.*;

public class TurnTest {

    HumanPlayer testPlayer = new HumanPlayer("bob", Color.CYAN);
    Turn testTurn = new Turn(testPlayer);
    @Test
    public void playerSignatureTest(){
        PlayersSignature returnValue = testTurn.getCurrentPlayersSignature();
        Assertions.assertEquals(testPlayer, returnValue);
    }

    @Test
    public void playerNameTest(){
        String returnName = testTurn.getName();
        Assertions.assertEquals("bob", returnName);
    }

}
