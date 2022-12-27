package GUI.playing.playingElements;

import GUI.Enums.FontScheme;

import javax.swing.*;
import java.awt.*;

public class StatesPanel extends JPanel {

    public StatesPanel() {
        this.setOpaque(false);
        JLabel label2 = new JLabel();
        label2.setText("Stats");
        label2.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.PLAIN, 50));
        this.add(label2);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,150));
    }
}
