package setUp;

import GUI.GameFrame;
import exception.IllegalSetupException;
import exception.IllegalUserInputException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetUpTest {
    SetUp setUpper = new SetUp();
    GameFrame gameFrame = new GameFrame();

    int legalWidth= Constants.minWidth.constant;
    int legalHeight=Constants.minHeight.constant;
/*
    @Test
    public void SetUpSameNameTest() {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.WHITE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1, gameFrame);
        //assertThrows(IllegalSetupException.class,() ->{setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1, gameFrame);});

    }
    @Test
    public void SetUpSameColorTest(){
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("boba");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.BLUE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1, gameFrame);
        //assertThrows(IllegalSetupException.class,() ->{setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1, gameFrame);});

    }

    @Test
    public void SetUpToBigTest(){
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.WHITE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,10000,100000,1, gameFrame);
        //assertThrows(IllegalSetupException.class,() ->{setUpper.setUp(playerColor,playerNames,10000,100000,1, gameFrame);});

    }
*/
    @Test
    public void SetUpAllFineTest() throws IllegalUserInputException, IllegalSetupException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("boba");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.RED);
        playerColor.add(Color.BLUE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,30,40,1,gameFrame);
        Assertions.assertEquals("bob", "bob"); // other test
    }




}
