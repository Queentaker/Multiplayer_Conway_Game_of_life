package GUI.playing.Grid;

import GUI.Enums.ColorScheme;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridPanel extends JPanel {
    private final ArrayList<ArrayList<GridButton>> grid;
    private final int length;
    private final int height;

    public GridPanel(int length, int height) {
        this.length = length;
        this.height = height;
        grid = new ArrayList<>();

        this.setBackground(ColorScheme.BRIGHT_COLOR.getColor());
        this.setLayout(new GridLayout(height, length,0,0));
        for(int y = 0; y < height; y++) {
            ArrayList<GridButton> row = new ArrayList<>();
            for(int x = 0; x < length; x++) {
                GridButton aGridButton = new GridButton(x,y);
                row.add(aGridButton);
                this.add(aGridButton);
            }
            grid.add(row);
        }
    }

    public void update(ArrayList<ArrayList<Color>> gridColors) {
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                grid.get(y).get(x).changeColor(gridColors.get(y).get(x));
            }
        }
    }
}
