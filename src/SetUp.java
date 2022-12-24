import enums.Constants;
import exception.IllegalSetupException;
import exception.IllegalUserInputException;
import gameFlow.CoordinatesTuple;
import gameFlow.GameManager;
import grid.Grid;
import player.HumanPlayer;
import player.Player;

import java.awt.*;
import java.util.List;

public class SetUp {
    private List<Player> players;
    private GameManager gameManager;

    public void setUp(List<Color> playerColors, List<String> playerNames, int height, int width, List<CoordinatesTuple> startConfiguration) throws IllegalSetupException, IllegalUserInputException {
        assert playerColors.size()==playerNames.size();
        if (!uniqueColors(playerColors)){
            throw new IllegalSetupException("You can't have same colors");
        }
        if (!uniqueNames(playerNames)){
            throw new IllegalSetupException("You can't have the same names");
        }
        if (!isGridSizeValid(height,width)){
            throw new IllegalSetupException("Grid doesn't meet limits");
        }
        int i=0;
        while (i<playerColors.size()){
            Player player=new HumanPlayer(playerNames.get(i),playerColors.get(i));
            players.add(player);
            i++;
        }

        gameManager = GameManager.getInstance(players);
        gameManager.startGame(startConfiguration,players, height, width);
        gameManager.manageGame();

    }
    private boolean isGridSizeValid(int height, int width){
        return height>= Constants.minHeight.constant & height<=Constants.maxHeight.constant & width>=Constants.minWidth.constant & width<=Constants.maxWidth.constant;
    }

    private boolean uniqueColors(List<Color> playerColor){
        for (int i=0;i< playerColor.size()-1;i++){
            Color color=playerColor.get(i);
            for (int j=0;j< playerColor.size();j++){
                if (i!=j & color==playerColor.get(j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean uniqueNames(List<String> playerNames){
        for (int i=0;i< playerNames.size()-1;i++){
            String name=playerNames.get(i);
            for (int j=0;j< playerNames.size();j++){
                if (i!=j & name.equals(playerNames.get(j))){
                    return false;
                }
            }
        }
        return true;
    }


}
