package GUI.playing.grid;

import GUI.enums.ColorScheme;
import GUI.GUI_Utility;
import grid.CoordinatesTuple;
import gameFlow.GameManager;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GridButton extends JButton implements ActionListener {
    private static final Border defaultBorder = BorderFactory.createLineBorder(ColorScheme.MEDIUM_COLOR.getColor(),1);
    private static final Border hoverBorder = BorderFactory.createLineBorder(ColorScheme.MEDIUM_COLOR.getColor(),4);

    private final int xCoordinate;
    private final int yCoordinate;
    private final MouseListener aListener;
    private static final String soundName = "src/GUI/sounds/clicksound.wav";


    public GridButton (int xCoordinate, int yCoordinate) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.setBackground(ColorScheme.BACKGROUND_COLOR.getColor());
        this.setFocusable(false);
        this.setOpaque(true);
        GridButton.this.setBorder(defaultBorder);
        aListener = (new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent entered) {
                GridButton.this.setBorder(hoverBorder);
            }

            @Override
            public void mouseExited(MouseEvent exited) {
                GridButton.this.setBorder(defaultBorder);
            }
        });
        this.addMouseListener(aListener);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CoordinatesTuple coordinatesTuple = new CoordinatesTuple(this.xCoordinate,this.yCoordinate);
        GUI_Utility.soundNotification(soundName);
        GameManager.getInstance().receiveCoordinates(coordinatesTuple);
    }

    public void changeColor(Color newColor) {
        this.setBackground(newColor);
    }

    public void disableButton() {
        this.setEnabled(false);
        this.removeMouseListener(aListener);
        this.setBorder(defaultBorder);
    }
}
