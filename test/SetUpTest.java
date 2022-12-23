import enums.Constants;
import exception.IllegalSetupException;
import exception.IllegalUserInputException;
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
        assertThrows(IllegalSetupException.class,() ->{setUpper.setUp(playerColor,playerNames,legalHeight,legalWidth);});

    }
}
