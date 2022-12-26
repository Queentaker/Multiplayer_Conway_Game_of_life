package GUI.setUp.setUpElements.PlayerSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chooseColor extends JButton implements ActionListener {
    public chooseColor() {
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(200,100));
        this.setBackground(Color.BLUE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass() == JButton.class) {
            JButton currentButton = (JButton) e.getSource();
            Color currentColor = currentButton.getBackground();
            Color color = JColorChooser.showDialog(null, "Pick a Color", currentColor);
            currentButton.setBackground(color);
        }
    }
}
