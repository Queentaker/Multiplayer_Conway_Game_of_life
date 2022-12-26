package GUI.setUp.setUpElements.PlayerSettings;

import GUI.Enums.ColorScheme;
import GUI.Enums.FontScheme;

import javax.swing.*;
import java.awt.*;

public class PlayerSettingPanel extends JPanel {

    public PlayerSettingPanel(String defaultName, Color defaultColor) {
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        this.setBackground(ColorScheme.BRIGHT_COLOR.getColor());
        this.setPreferredSize(new Dimension(300, 300));

        JLabel title = new JLabel(defaultName + " Settings");
        title.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.BOLD, 24));
        title.setForeground(ColorScheme.DARK_COLOR.getColor());
        title.setOpaque(false);
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title, BorderLayout.NORTH);

        this.add(new ChooseColor(defaultColor,defaultName + " Color"), BorderLayout.SOUTH);
        this.add(new ChooseName(defaultName + "Name"), BorderLayout.CENTER);
    }

}
