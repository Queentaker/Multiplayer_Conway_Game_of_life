import GUI.GameFrame;
import exception.IllegalNameOrColorException;
import exception.IllegalSetupException;
import exception.IllegalUserInputException;
import org.junit.jupiter.api.Test;
import setUp.SetUp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SetUpTest {
    SetUp setUpper = new SetUp();
    private int gridSize = 5;
    GameFrame gameFrame = new GameFrame();

    @Test
    public void SetUpSameName() throws IllegalNameOrColorException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.WHITE);
        try{
            setUpper.setUp(playerColor, playerNames, gridSize,gridSize, 1,gameFrame);
        } catch (IllegalSetupException | IllegalUserInputException e){

        }

    }
}
