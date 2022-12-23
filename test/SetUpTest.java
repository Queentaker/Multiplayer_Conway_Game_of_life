import exception.IllegalNameOrColorException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SetUpTest {
    SetUp setUpper = new SetUp();
    private int gridSize = 5;
    @Test
    public void SetUpSameName() throws IllegalNameOrColorException {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("bob");
        playerNames.add("bob");
        List<Color> playerColor = new ArrayList<>();
        playerColor.add(Color.BLUE);
        playerColor.add(Color.WHITE);
        try{
            setUpper.setUp((ArrayList<Color>) playerColor, (ArrayList<String>) playerNames, gridSize);
        } catch (IllegalNameOrColorException e){

        }

    }
}
