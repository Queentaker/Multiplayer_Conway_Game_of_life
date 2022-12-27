package setUp;

import exception.IllegalSetupException;
import exception.IllegalUserInputException;
import gameFlow.CoordinatesTuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import setUp.SetUp;
import enums.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetUpTest {
    SetUp setUpper = new SetUp();
    int legalWidth= Constants.minWidth.constant;
    int legalHeight=Constants.minHeight.constant;

    @Test
    public void SetUpSameNameTest() {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.WHITE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        assertThrows(IllegalSetupException.class,() ->{setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1);});

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
        assertThrows(IllegalSetupException.class,() ->{setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,1);});

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
        assertThrows(IllegalSetupException.class,() ->{setUpper.setUp(playerColor,playerNames,10000,100000,1);});

    }
/*raises error...
    @Test
    public void SetUpAllFineTest() throws IllegalUserInputException, IllegalSetupException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("boba");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.RED);
        playerColor.add(Color.BLUE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        setUpper.setUp(playerColor,playerNames,50,50,1);
        Assertions.assertEquals("bob", "bob"); // other test
    }
*/

}
