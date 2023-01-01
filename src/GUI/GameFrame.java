package GUI;

import GUI.enums.ColorScheme;
import GUI.generalElements.PlayerInformationPanel;
import GUI.generalElements.Title;
import GUI.playing.PlayingPanel;
import GUI.setUp.SetUpPanel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameFrame extends JFrame implements FrameObserver {
    JPanel title;
    PlayerInformationPanel information;
    PlayingPanel playingPanel;
    SetUpPanel setUpPanel;
    private static final String winningSoundName = "src/GUI/sounds/winnersound.wav";
    private static final String errorSoundName = "src/GUI/sounds/clickerrorsound.wav";
    private static final String successSoundName = "src/GUI/sounds/clicksound.wav";
    private static final String setUpSoundName = "src/GUI/sounds/openingguisound.wav";

    public GameFrame() {
        this.setTitle("Conway's Game of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,850);
        this.getContentPane().setBackground(ColorScheme.BACKGROUND_COLOR.getColor());
        GUI_Utility.changeIcon(this, "ownTaskbarLogo");
        title = new Title();
        this.add(title, BorderLayout.NORTH);
        information = new PlayerInformationPanel();
        this.add(information, BorderLayout.SOUTH);
        JPanel borderPanelLeft = new JPanel();
        borderPanelLeft.setOpaque(false);
        borderPanelLeft.setPreferredSize(new Dimension(100,50));
        this.add(borderPanelLeft, BorderLayout.WEST);
        JPanel borderPanelRight = new JPanel();
        borderPanelRight.setOpaque(false);
        borderPanelRight.setPreferredSize(new Dimension(100,50));
        this.add(borderPanelRight, BorderLayout.EAST);
        setUpPanel = new SetUpPanel(this);
        this.add(setUpPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void setUpFinished(int length, int height, Color player1Color, String player1Name, Color player2Color,
                              String player2Name, int livingCells) {
        setUpPanel.setVisible(false);
        this.remove(setUpPanel);
        playingPanel = new PlayingPanel(length, height, player1Color, player1Name, player2Color, player2Name, livingCells);
        this.add(playingPanel);
        GUI_Utility.soundNotification(setUpSoundName);
    }

    @Override
    public void updateGeneral(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message,
                              ArrayList<ArrayList<Color>> gridColors) {
        GUI_Utility.soundNotification(successSoundName);
        information.update(message);
        playingPanel.update(cellsAlivePlayer1, cellsAlivePlayer2, generation, gridColors);
    }

    @Override
    public void updateMessage(String message) {
        GUI_Utility.soundNotification(errorSoundName);
        information.update(message);
    }

    public void declareWinner(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message,
                              ArrayList<ArrayList<Color>> gridColors) {
        updateGeneral(cellsAlivePlayer1, cellsAlivePlayer2, generation, message, gridColors);
        GUI_Utility.soundNotification(winningSoundName);
        playingPanel.declareWinner();
    }
}
