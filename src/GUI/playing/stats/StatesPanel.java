package GUI.playing.stats;

import GUI.Enums.FontScheme;

import javax.swing.*;
import java.awt.*;

public class StatesPanel extends JPanel {
    StatsProgressBar progressBar;

    public StatesPanel(Color player1Color, Color player2Color) {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        progressBar = new StatsProgressBar(player1Color, player2Color);
        this.add(progressBar, BorderLayout.CENTER);

        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,150));
    }
}
