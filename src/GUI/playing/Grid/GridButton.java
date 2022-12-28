package GUI.playing.Grid;

import GUI.Enums.ColorScheme;
import gameFlow.CoordinatesTuple;
import gameFlow.GameManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class GridButton extends JButton implements ActionListener {
    private static final Border defaultBorder = BorderFactory.createLineBorder(ColorScheme.MEDIUM_COLOR.getColor(),2);
    private static final Border hoverBorder = BorderFactory.createLineBorder(ColorScheme.MEDIUM_COLOR.getColor(),4);

    private final int xCoordinate;
    private final int yCoordinate;

    public GridButton (int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.setBackground(ColorScheme.BACKGROUND_COLOR.getColor());
        this.setFocusable(false);
        this.setOpaque(true);
        GridButton.this.setBorder(defaultBorder);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent entered) {
                GridButton.this.setBorder(hoverBorder);
            }

            @Override
            public void mouseExited(MouseEvent exited) {
                GridButton.this.setBorder(defaultBorder);
            }
        });

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Call method with (this.xCoordinate, this.yCoordinate)
        System.out.println("X-Coordinate: " + xCoordinate);
        System.out.println("Y-Coordinate: " + yCoordinate);
        this.setBackground(Color.CYAN);
        CoordinatesTuple coordinatesTuple = new CoordinatesTuple(this.xCoordinate,this.yCoordinate);
        GameManager.getInstance().sendCoordinates(coordinatesTuple);
    }

    public void changeColor(Color newColor) {
        this.setBackground(newColor);
    }

    public void disableButton() {
        this.setEnabled(false);
        MouseListener aListener = this.getMouseListeners()[0];
        this.removeMouseListener(aListener);
    }
}
