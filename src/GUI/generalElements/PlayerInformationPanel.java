package GUI.generalElements;

import GUI.GUI_Utility;

import javax.swing.*;
import java.awt.*;

public class PlayerInformationPanel extends JPanel {
    public PlayerInformationPanel() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150,120));
        JLabel leftUpperDecoration = GUI_Utility.ImageNameToLabel("LeftLowerCorner", 240, 120);
        this.add(leftUpperDecoration, BorderLayout.WEST);
        JLabel RightUpperDecoration = GUI_Utility.ImageNameToLabel("RightLowerCorner", 240, 120);
        this.add(RightUpperDecoration, BorderLayout.EAST);
    }
}
