package GUI.Grid;

import GUI.Enums.ColorScheme;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    public Grid(int length, int height) {
        this.setBackground(ColorScheme.LIGHT_COLOR.getColor());
        this.setLayout(new GridLayout(length, height));
        for(int x = 0; x < length; x++) {
            for(int y = 0; y < height; y++) {
                this.add(new GridButton(x,y));
            }
        }
    }
}
