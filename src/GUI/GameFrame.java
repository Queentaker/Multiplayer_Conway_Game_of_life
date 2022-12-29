package GUI;

import GUI.Enums.ColorScheme;
import GUI.generalElements.PlayerInformationPanel;
import GUI.generalElements.Title;
import GUI.playing.PlayingPanel;
import GUI.setUp.SetUpPanel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameFrame extends JFrame implements FrameObserver {
    JPanel title;
    PlayerInformationPanel information;
    PlayingPanel playingPanel;
    SetUpPanel setUpPanel;
    String soundName = "src/GUI/sounds/winnersound.wav";


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
                              String player2Name, int livingCells) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        setUpPanel.setVisible(false);
        this.remove(setUpPanel);

        playingPanel = new PlayingPanel(length, height, player1Color, player1Name, player2Color, player2Name, livingCells);
        this.add(playingPanel);
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
    public void updateGeneral(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message,
                              ArrayList<ArrayList<Color>> gridColors) {
        updateMessage(message);
        playingPanel.update(cellsAlivePlayer1, cellsAlivePlayer2, generation, gridColors);
    }
    @Override
    public void updateMessage(String message) {
        information.update(message);
    }

    public void declareWinner(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message,
                              ArrayList<ArrayList<Color>> gridColors) {
        updateGeneral(cellsAlivePlayer1, cellsAlivePlayer2, generation, message, gridColors);
        playSound(soundName);
        playingPanel.declareWinner();
    }
}
