package GUI.playing.stats;

import GUI.Enums.ColorScheme;
import GUI.Enums.FontScheme;

import javax.swing.*;
import java.awt.*;

public class StatesPanel extends JPanel {
    private final StatsProgressBar progressBar;
    private final StatsPlayerPanel player1Panel;
    private final StatsPlayerPanel player2Panel;
    private final JLabel generation;

    public StatesPanel(Color player1Color, String player1Name, Color player2Color, String player2Name, int livingCells) {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        generation = new JLabel("Generation: 0");
        generation.setOpaque(false);
        generation.setHorizontalAlignment(JLabel.CENTER);
        generation.setForeground(ColorScheme.DARK_COLOR.getColor());
        generation.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.BOLD, 24));
        generation.setPreferredSize(new Dimension(200, 30));
        this.add(generation, BorderLayout.NORTH);

        progressBar = new StatsProgressBar(player1Color, player2Color);
        this.add(progressBar, BorderLayout.CENTER);

        player1Panel = new StatsPlayerPanel(player1Name, player1Color, livingCells);
        this.add(player1Panel, BorderLayout.WEST);
        player2Panel = new StatsPlayerPanel(player2Name, player2Color, livingCells);
        this.add(player2Panel, BorderLayout.EAST);

        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,100));
    }

    public void update(int player1Value, int player2Value, int generation) {
        this.generation.setText("Generation: " + Integer.toString(generation));
        player1Panel.update(player1Value);
        player2Panel.update(player2Value);
        progressBar.update(player1Value, player2Value);
    }
}
