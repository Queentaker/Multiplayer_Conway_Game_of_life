package GUI.setUp.setUpElements.PlayerSettings;

import GUI.Enums.ColorScheme;
import GUI.Enums.FontScheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseColor extends JButton implements ActionListener {
    private Color currentColor;

    public ChooseColor(Color defaultColor, String title) {
        currentColor = defaultColor;
        this.setOpaque(true);
        this.setText(title);
        this.setFocusable(false);
        this.setForeground(ColorScheme.DARK_COLOR.getColor());
        this.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.PLAIN, 24));
        this.setPreferredSize(new Dimension(100,80));
        this.setBorder(BorderFactory.createLineBorder(currentColor, 8));
        this.setBackground(ColorScheme.MEDIUM_BRIGHT_COLOR.getColor());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentColor = JColorChooser.showDialog(null, "Pick a Color", currentColor);
        this.setBorder(BorderFactory.createLineBorder(currentColor, 8));
    }

    public Color getCurrentColor() {
        return currentColor;
    }
}
