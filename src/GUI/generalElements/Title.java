package GUI.generalElements;

import GUI.Enums.ColorScheme;
import GUI.GUI_Utility;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Title extends JPanel {

    public Title() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150,120));
        JLabel leftUpperDecoration = GUI_Utility.ImageNameToLabel("Corners/LeftUpperCorner", 240, 120);
        this.add(leftUpperDecoration, BorderLayout.WEST);
        JLabel RightUpperDecoration = GUI_Utility.ImageNameToLabel("Corners/RightUpperCorner", 240, 120);
        this.add(RightUpperDecoration, BorderLayout.EAST);
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(new Rectangle(800, 120));
        JLabel titleLabel = GUI_Utility.ImageNameToLabel("TitleLogo", 740, 100);
        titleLabel.setBackground(ColorScheme.BACKGROUND_COLOR.getColor());
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titleLabel, BorderLayout.CENTER);
    }
}
