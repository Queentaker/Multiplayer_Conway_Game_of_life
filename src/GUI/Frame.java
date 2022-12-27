package GUI;

import GUI.Enums.ColorScheme;
import GUI.generalElements.PlayerInformationPanel;
import GUI.generalElements.Title;
import GUI.playing.Grid.GridButton;
import GUI.playing.Grid.GridPanel;
import GUI.playing.PlayingPanel;
import GUI.setUp.SetUpPanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame implements FrameObserver {
    JPanel title;
    PlayerInformationPanel information;
    PlayingPanel playingPanel;
    SetUpPanel setUpPanel;


    public Frame() {
        this.setTitle("Conway's Game of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,1000);
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

    public void setUpFinished(int length, int height, Color player1Color, String player1Name, Color player2Color,
                              String player2Name, int livingCells) {
        setUpPanel.setVisible(false);
        this.remove(setUpPanel);
        JPanel borderPanelLeft = new JPanel();
        borderPanelLeft.setOpaque(false);
        borderPanelLeft.setPreferredSize(new Dimension(100,50));
        this.add(borderPanelLeft, BorderLayout.WEST);
        JPanel borderPanelRight = new JPanel();
        borderPanelRight.setOpaque(false);
        borderPanelRight.setPreferredSize(new Dimension(100,50));
        this.add(borderPanelRight, BorderLayout.EAST);
        playingPanel = new PlayingPanel(length, height, player1Color, player1Name, player2Color, player2Name, livingCells);
        this.add(playingPanel);
    }

    @Override
    public void update(int cellsAlivePlayer1, int cellsAlivePlayer2, int generationPlayer1, int generationPlayer2) {

    }
}
