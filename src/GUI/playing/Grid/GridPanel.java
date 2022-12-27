package GUI.playing.Grid;

import GUI.Enums.ColorScheme;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridPanel extends JPanel {
    public GridPanel(int length, int height) {
        this.setBackground(ColorScheme.BRIGHT_COLOR.getColor());
        this.setLayout(new GridLayout(height, length,0,0));
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < length; y++) {
                this.add(new GridButton(x,y));
            }
        }
    }
}
