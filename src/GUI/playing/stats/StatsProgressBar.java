package GUI.playing.stats;

import GUI.Enums.ColorScheme;

import javax.swing.*;
import java.awt.*;

public class StatsProgressBar extends JProgressBar {

    public StatsProgressBar(Color player1Color, Color player2Color) {
        this.setValue(50);
        this.setOpaque(false);
        this.setBackground(player2Color);
        this.setForeground(player1Color);
        this.setPreferredSize(new Dimension( 20, 200));
    }

    public void update(int player1Value, int player2Value) {
        if (player1Value == 0) {
            this.setValue(0);
        } else if (player2Value == 0) {
            this.setValue(100);
        } else {
            float player1Float = (float) player1Value;
            float player2Float = (float) player1Value;
            float ratio = player1Value / (player1Float + player2Float);
            int value = Math.round(100 * ratio);
            this.setValue(value);
        }
    }
}
