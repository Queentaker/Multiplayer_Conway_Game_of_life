package GUI;

import jdk.internal.org.jline.utils.Colors;

import java.awt.*;
import java.util.ArrayList;

public interface FrameObserver {
    public void updateGeneral(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message,
                              ArrayList<ArrayList<Color>> gridColors);

    public void updateMessage(String message);

    public void declareWinner(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message,
                              ArrayList<ArrayList<Color>> gridColors);
}
