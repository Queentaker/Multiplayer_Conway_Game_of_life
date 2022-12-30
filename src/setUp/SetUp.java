package setUp;

import GUI.FrameObserver;
import GUI.GUI_Utility;
import enums.Constants;
import gameFlow.GameManager;
import grid.Grid;
import grid.startingTemplates.Template;
import grid.startingTemplates.TemplatesEnum;
import player.HumanPlayer;
import player.Player;
import player.PlayersSignature;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetUp {
    public List<Player> players; //must be again private
    private GameManager gameManager;
    String soundName = "src/GUI/sounds/openingguisound.wav";

    public void setUp(List<Color> playerColors, List<String> playerNames, int height, int width, int startingTemplate, FrameObserver frame) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        assert playerColors.size()==playerNames.size();

        if (isColorToBright(playerColors)){
            frame.updateMessage("One of the colors is to bright, make sure your colors aren't to whitish");
        } else if (!uniqueColors(playerColors)){
            frame.updateMessage("You can't have same colors");
        }else if (colorsToSimialar(playerColors)){
            frame.updateMessage("Your colors are to similar make sure you choose different colors that have at least an rgb difference of "
                    + Constants.minimumRGBDistance.constant);
        }else if (!uniqueNames(playerNames)){
            frame.updateMessage("You can't have the same names");
        } else if (!isGridSizeValid(height,width)){
            frame.updateMessage("Grid doesn't meet limits");
        } else {

            int i = 0;
            List<PlayersSignature> playersSignature = new ArrayList<>();
            players = new ArrayList<>();
            while (i < playerColors.size()) {
                Player player = new HumanPlayer(playerNames.get(i), playerColors.get(i));
                players.add(player);
                playersSignature.add(player);
                i++;
            }
            Grid grid = new Grid(height, width);
            Template template = TemplatesEnum.getTemplate(startingTemplate);
            template.addTemplate(grid, playersSignature);
            gameManager = GameManager.getInstance(players, grid);
            int cellsAlive = grid.cellsAlivePlayer(players.get(0));
            frame.setUpFinished(width, height, playerColors.get(0), playerNames.get(0), playerColors.get(1), playerNames.get(1),
                    cellsAlive);
            gameManager.registerObserver(frame);
            GUI_Utility.soundNotification(soundName);
            gameManager.setMeasurements("remove");
        }
    }
    private boolean isGridSizeValid(int height, int width){
        return height>= Constants.minHeight.constant & height<=Constants.maxHeight.constant & width>=Constants.minWidth.constant & width<=Constants.maxWidth.constant;
    }

    private boolean uniqueColors(List<Color> playerColor){
        for (int i=0;i< playerColor.size()-1;i++){
            Color color=playerColor.get(i);
            for (int j=0;j< playerColor.size();j++){
                if (i!=j && color==playerColor.get(j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isColorToBright(List<Color> playerColors) {
        for(Color aColor: playerColors) {
            assert aColor!= null;
            int brightnessLevel = 0;
            brightnessLevel += aColor.getBlue();
            brightnessLevel += aColor.getRed();
            brightnessLevel += aColor.getGreen();
            if (brightnessLevel >= 720) {
                return true;
            }
        }
        return false;
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

    private boolean colorsToSimialar(List<Color> playerColors){
        int [] rgbValues=new int[playerColors.size()];
        int i=0;
        for (Color color:playerColors){
            assert color!=null;
            rgbValues[i]=color.getRGB();
            i++;
        }
        for (int j=0;j<rgbValues.length;j++){
            for (int k=0;k<rgbValues.length;k++){
                if (j!=k){
                    int rgbDifference=rgbValues[j]-rgbValues[k];
                    if (Math.abs(rgbDifference)<Constants.minimumRGBDistance.constant){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
