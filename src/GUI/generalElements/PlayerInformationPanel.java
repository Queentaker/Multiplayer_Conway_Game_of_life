package GUI.generalElements;

import GUI.Enums.ColorScheme;
import GUI.Enums.FontScheme;
import GUI.GUI_Utility;

import javax.swing.*;
import java.awt.*;

public class PlayerInformationPanel extends JPanel {
    JLabel information;
    public PlayerInformationPanel() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150,120));
        JLabel leftUpperDecoration = GUI_Utility.ImageNameToLabel("Corners/LeftLowerCorner", 240, 120);
        this.add(leftUpperDecoration, BorderLayout.WEST);
        JLabel RightUpperDecoration = GUI_Utility.ImageNameToLabel("Corners/RightLowerCorner", 240, 120);
        this.add(RightUpperDecoration, BorderLayout.EAST);

        information = new JLabel();
        information.setText("");
        information.setOpaque(false);
        information.setHorizontalAlignment(JLabel.CENTER);
        information.setVerticalAlignment(JLabel.CENTER);
        information.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.PLAIN, 36));
        information.setForeground(ColorScheme.DARK_COLOR.getColor());
        this.add(information, BorderLayout.CENTER);
    }

    public void update(String message) {
        information.setText(message);
    }
}
