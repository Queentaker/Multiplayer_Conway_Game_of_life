package GUI.playing.stats;

import GUI.enums.FontScheme;

import javax.swing.*;
import java.awt.*;

public class StatsPlayerPanel extends JPanel {
    JLabel stats;

    public StatsPlayerPanel(String playerName, Color playerColor, int livingCells) {
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(200,55));
        this.setLayout(new BorderLayout());

        JLabel name = new JLabel(playerName);
        name.setForeground(playerColor);
        name.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.BOLD, 24));
        name.setOpaque(false);
        name.setHorizontalAlignment(JLabel.CENTER);
        this.add(name, BorderLayout.NORTH);

        stats = new JLabel(Integer.toString(livingCells));
        stats.setForeground(playerColor);
        stats.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.PLAIN, 24));
        stats.setHorizontalAlignment(JLabel.CENTER);
        this.add(stats, BorderLayout.SOUTH);
    }

    public void update(int newValue) {
        stats.setText(Integer.toString(newValue));
    }
}
