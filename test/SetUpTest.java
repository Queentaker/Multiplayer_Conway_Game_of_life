import GUI.GameFrame;
import exception.IllegalNameOrColorException;
import exception.IllegalSetupException;
import exception.IllegalUserInputException;
import org.junit.jupiter.api.Test;
import setUp.SetUp;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetUpTest {
    SetUp setUpper = new SetUp();
    private int gridSize = 5;
    GameFrame gameFrame = new GameFrame();

    @Test
    public void SetUpSameName() throws IllegalNameOrColorException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.WHITE);
        setUpper.setUp(playerColor, playerNames, gridSize,gridSize, 1,gameFrame);

    }
}
