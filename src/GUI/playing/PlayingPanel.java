package GUI.playing;

import GUI.playing.Grid.GridPanel;
import GUI.playing.stats.StatesPanel;

import javax.swing.*;
import java.awt.*;

public class PlayingPanel extends JPanel {
    GridPanel grid;
    StatesPanel stats;

    public PlayingPanel(int length, int height, Color player1Color, String player1Name, Color player2Color,
                        String player2Name, int livingCells) {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        JPanel borderPanelLeft = new JPanel();
        borderPanelLeft.setOpaque(false);
        borderPanelLeft.setPreferredSize(new Dimension(25,25));
        this.add(borderPanelLeft, BorderLayout.NORTH);
        grid = new GridPanel(length, height);
        this.add(grid, BorderLayout.CENTER);
        stats = new StatesPanel(player1Color, player1Name, player2Color, player2Name, livingCells);
        this.add(stats, BorderLayout.SOUTH);
    }

    public void update(int player1Value, int player2Value, int generation) {
        stats.update(player1Value, player2Value, generation);
        grid.update();
    }
}
