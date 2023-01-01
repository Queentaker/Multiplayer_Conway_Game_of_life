package GUI.playing.grid;

import GUI.enums.ColorScheme;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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
        for(int a = 0; a < height; a++) {
            ArrayList<GridButton> row = new ArrayList<>();
            for(int b = 0; b < length; b++) {
                GridButton aGridButton = new GridButton(a,b);
                row.add(aGridButton);
                this.add(aGridButton);
            }
            grid.add(row);
        }
    }

    public void update(ArrayList<ArrayList<Color>> gridColors) {
        for(int a = 0; a < height; a++) {
            for (int b = 0; b < length; b++) {
                grid.get(a).get(b).changeColor(gridColors.get(a).get(b));
            }
        }
    }

    public void disableButtons() {
        for(int a = 0; a < height; a++) {
            for (int b = 0; b < length; b++) {
                grid.get(a).get(b).disableButton();
            }
        }
    }
}
