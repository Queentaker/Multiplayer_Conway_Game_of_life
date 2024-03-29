package setUp;




import grid.CoordinatesTuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import enums.Constants;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SetUpTest {
    SetUp setUpper = new SetUp();
    MockObserver gameFrame = new MockObserver();

    int legalWidth= Constants.minWidth.constant;
    int legalHeight=Constants.minHeight.constant;


    @Test
    public void ColorToWhitishTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("anna");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(new Color(100,100,100));
        playerColor.add(new Color (255,250,250));
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1, gameFrame);
        Assertions.assertEquals("One of the colors is too bright, make sure your colors are not too whitish", gameFrame.getMessage());
    }

    @Test
    public void ColorToSimilarTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("anna");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(new Color(100,100,100));
        playerColor.add(new Color (100,100,99));
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1, gameFrame);
        Assertions.assertEquals("Your colors are too similar", gameFrame.getMessage());
    }

    @Test
    public void SetUpSameNameTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.RED);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1, gameFrame);
        Assertions.assertEquals("You cannot have the same names", gameFrame.getMessage());
    }
    @Test
    public void SetUpSameColorTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("anna");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.BLUE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1, gameFrame);
        Assertions.assertEquals("You cannot have the same colors", gameFrame.getMessage());
    }

    @Test
    public void SetUpToBigTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("anna");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.RED);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,10000,100000,1, gameFrame);
        Assertions.assertEquals("Grid does not meet the limits", gameFrame.getMessage());
    }

    @Test
    public void SetUpAllFineTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("anna");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.RED);
        playerColor.add(Color.BLUE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,30,40,1, gameFrame);
        Assertions.assertTrue(gameFrame.isSetUpFinished());
    }
}
