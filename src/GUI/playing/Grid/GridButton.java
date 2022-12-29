package GUI.playing.Grid;

import GUI.Enums.ColorScheme;
import grid.CoordinatesTuple;
import gameFlow.GameManager;

import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GridButton extends JButton implements ActionListener {
    private static final Border defaultBorder = BorderFactory.createLineBorder(ColorScheme.MEDIUM_COLOR.getColor(),1);
    private static final Border hoverBorder = BorderFactory.createLineBorder(ColorScheme.MEDIUM_COLOR.getColor(),4);

    private final int xCoordinate;
    private final int yCoordinate;
    private MouseListener aListener;
    String soundName = "src/GUI/sounds/clicksound.wav";

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
    public static synchronized void playSound(String soundName) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        CoordinatesTuple coordinatesTuple = new CoordinatesTuple(this.xCoordinate,this.yCoordinate);
        playSound(soundName);
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
