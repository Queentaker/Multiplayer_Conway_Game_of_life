package GUI.generalElements;

import GUI.GUI_Utility;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Title extends JPanel {

    public Title() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150,120));
        JLabel leftUpperDecoration = GUI_Utility.ImageNameToLabel("LeftUpperCorner", 240, 120);
        this.add(leftUpperDecoration, BorderLayout.WEST);
        JLabel logo = GUI_Utility.ImageNameToLabel("ownLogo", 130, 130);
        this.add(logo, BorderLayout.EAST);
    }
}
