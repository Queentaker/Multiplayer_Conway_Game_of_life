package GUI.setUp.setUpElements.PlayerSettings;

import GUI.enums.ColorScheme;
import GUI.enums.FontScheme;

import javax.swing.*;
import java.awt.*;

public class PlayerSettingPanel extends JPanel {
    ChooseColor colorChoooser;
    ChooseName nameChooser;

    public PlayerSettingPanel(String defaultName, Color defaultColor) {
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        this.setBackground(ColorScheme.BRIGHT_COLOR.getColor());
        this.setPreferredSize(new Dimension(300, 200));
        this.setBorder(BorderFactory.createLineBorder(ColorScheme.BRIGHT_COLOR.getColor(), 12));
        JLabel title = new JLabel(defaultName + " Settings");
        title.setFont(new Font(FontScheme.STANDARD_FONT.getFontName(), Font.BOLD, 24));
        title.setForeground(ColorScheme.DARK_COLOR.getColor());
        title.setOpaque(false);
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title, BorderLayout.NORTH);
        colorChoooser = new ChooseColor(defaultColor, defaultName + " Color");
        this.add(colorChoooser, BorderLayout.SOUTH);
        nameChooser = new ChooseName(defaultName + " Name");
        this.add(nameChooser, BorderLayout.CENTER);
    }

    public Color getCurrentColor() {
        return colorChoooser.getCurrentColor();
    }

    public String getCurrentName() {
        return nameChooser.getText();
    }
}
