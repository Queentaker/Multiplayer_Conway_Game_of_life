package GUI.playing.playingElements;

import javax.swing.*;
import java.awt.*;

public class PlayerInformationPanel extends JPanel {
    public PlayerInformationPanel() {
        this.setBackground(Color.CYAN);
        this.setOpaque(false);
        JLabel label3 = new JLabel();
        label3.setText("Player guiding");
        label3.setFont(new Font("Arial", Font.PLAIN, 50));
        this.add(label3);
        this.setPreferredSize(new Dimension(100,100));
    }
}
