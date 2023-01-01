package GUI.setUp.setUpElements.PlayerSettings;

import GUI.enums.ColorScheme;
import GUI.enums.FontScheme;

import javax.swing.*;
import java.awt.*;

public class ChooseName extends JTextField {

    public ChooseName(String defaultName) {
        this.setText(defaultName);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBackground(ColorScheme.MEDIUM_BRIGHT_COLOR.getColor());
        this.setForeground(ColorScheme.DARK_COLOR.getColor());
        this.setFont(new Font(FontScheme.STANDARD_FONT.getFontName(), Font.PLAIN, 24));
        this.setPreferredSize(new Dimension(200,80));
    }
}
