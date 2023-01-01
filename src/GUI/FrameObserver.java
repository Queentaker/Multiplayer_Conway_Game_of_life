package GUI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public interface FrameObserver {
    public void updateGeneral(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message,
                              ArrayList<ArrayList<Color>> gridColors);

    public void updateMessage(String message);

    public void declareWinner(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message,
                              ArrayList<ArrayList<Color>> gridColors);

    public void setUpFinished(int length, int height, Color player1Color, String player1Name, Color player2Color,
                              String player2Name, int livingCells) throws UnsupportedAudioFileException, LineUnavailableException, IOException;
}
