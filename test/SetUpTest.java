import enums.Constants;
import exception.IllegalSetupException;
import exception.IllegalUserInputException;
import gameFlow.CoordinatesTuple;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetUpTest {
    SetUp setUpper = new SetUp();
    int legalWidth= Constants.minWidth.constant;
    int legalHeight=Constants.minHeight.constant;
    @Test
    public void SetUpSameName() {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.WHITE);
        List<CoordinatesTuple> startingPosition = new ArrayList<>();
        startingPosition.add(new CoordinatesTuple(1,1));
        assertThrows(IllegalSetupException.class,() ->{setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth,startingPosition);});

    }
}
