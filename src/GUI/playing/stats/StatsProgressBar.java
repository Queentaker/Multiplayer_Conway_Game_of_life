package GUI.playing.stats;

import GUI.Enums.FontScheme;

import javax.swing.*;
import java.awt.*;

//Works less good on MacOS, most of the JProgressBar Settings don't work
public class StatsProgressBar extends JPanel {
    JProgressBar progressBar;
    JLabel percentage;

    public StatsProgressBar(Color player1Color, Color player2Color) {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        progressBar = new JProgressBar();
        progressBar.setValue(50);
        progressBar.setOpaque(false);
        progressBar.setBackground(player2Color);
        progressBar.setForeground(player1Color);
        progressBar.setPreferredSize(new Dimension( 20, 30));
        this.add(progressBar, BorderLayout.CENTER);

        percentage = new JLabel("50 %");
        percentage.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.PLAIN, 24));
        percentage.setOpaque(false);
        percentage.setHorizontalAlignment(JLabel.CENTER);
        this.add(percentage, BorderLayout.SOUTH);
    }

    public void update(int player1Value, int player2Value) {
        if (player1Value == 0) {
            progressBar.setValue(0);
            percentage.setText("0 %");
        } else if (player2Value == 0) {
            progressBar.setValue(100);
            percentage.setText("100 %");
        } else {
            float player1Float = (float) player1Value;
            float player2Float = (float) player1Value;
            float ratio = player1Value / (player1Float + player2Float);
            int value = Math.round(100 * ratio);
            progressBar.setValue(value);
            percentage.setText(Integer.toString(value) + " %");
        }
    }
}
