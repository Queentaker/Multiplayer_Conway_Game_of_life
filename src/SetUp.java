import exception.IllegalNameOrColorException;
import grid.Grid;
import player.HumanPlayer;

import java.awt.*;
import java.util.ArrayList;

public class SetUp {
    private HumanPlayer playerOne;
    private HumanPlayer playerTwo;
    private Grid board;
    public void setUp(ArrayList<Color> playerColor, ArrayList<String> playerName, int size ) throws IllegalNameOrColorException {
        if (playerColor.get(0).equals(playerColor.get(1)) || playerName.get(0).equals(playerName.get(1))){

            throw new IllegalNameOrColorException("You can't have the same name or the same color");
        }
        else{
            playerOne = new HumanPlayer(playerName.get(0),playerColor.get(0));
            playerTwo = new HumanPlayer(playerName.get(1), playerColor.get(1));
            board = new Grid(size);
        }
    }
}