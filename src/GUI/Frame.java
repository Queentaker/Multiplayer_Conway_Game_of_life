package GUI;

import GUI.Enums.ColorScheme;
import GUI.generalElements.Title;
import GUI.playing.Grid.GridButton;
import GUI.playing.Grid.GridPanel;
import GUI.setUp.SetUpPanel;
import GUI.playing.playingElements.PlayerInformationPanel;
import GUI.playing.playingElements.StatesPanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    JPanel title;
    JPanel stats;
    JPanel information;
    JPanel aGrid;
    SetUpPanel setUpPanel;


    public Frame() {
        this.setTitle("Conway's Game of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.getContentPane().setBackground(ColorScheme.BACKGROUND_COLOR.getColor());
        GUI_Utility.changeIcon(this, "ownTaskbarLogo");

        title = new Title();
        this.add(title, BorderLayout.NORTH);

        information = new PlayerInformationPanel();
        this.add(information, BorderLayout.SOUTH);

        setUpPanel = new SetUpPanel(this);
        this.add(setUpPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void setUpFinished(int length, int height) {
        setUpPanel.setVisible(false);
        this.remove(setUpPanel);

        stats = new StatesPanel();
        this.add(stats, BorderLayout.EAST);

        information = new PlayerInformationPanel();
        this.add(information, BorderLayout.SOUTH);

        aGrid = new GridPanel(length, height);
        this.add(aGrid, BorderLayout.CENTER);
    }


}
