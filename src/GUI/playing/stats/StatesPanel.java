package GUI.playing.stats;

import GUI.Enums.FontScheme;

import javax.swing.*;
import java.awt.*;

public class StatesPanel extends JPanel {
    private final StatsProgressBar progressBar;
    private final StatsPlayerPanel player1Panel;
    private final StatsPlayerPanel player2Panel;

    public StatesPanel(Color player1Color, String player1Name, Color player2Color, String player2Name, int livingCells) {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        progressBar = new StatsProgressBar(player1Color, player2Color);
        this.add(progressBar, BorderLayout.CENTER);

        player1Panel = new StatsPlayerPanel(player1Name, player1Color, livingCells);
        this.add(player1Panel, BorderLayout.WEST);
        player2Panel = new StatsPlayerPanel(player2Name, player2Color, livingCells);
        this.add(player2Panel, BorderLayout.EAST);

        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,75));
    }

    public void update() {

    }
}
