package GUI.playing;

import GUI.playing.Grid.GridPanel;
import GUI.playing.playingElements.StatesPanel;

import javax.swing.*;
import java.awt.*;

public class PlayingPanel extends JPanel {
    GridPanel grid;
    StatesPanel stats;

    public PlayingPanel(int length, int height) {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        grid = new GridPanel(length, height);
        this.add(grid, BorderLayout.CENTER);
        stats = new StatesPanel();
        this.add(stats, BorderLayout.SOUTH);
    }

}
