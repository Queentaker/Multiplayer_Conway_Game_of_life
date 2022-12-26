package GUI.setUp;

import GUI.Enums.ColorScheme;
import GUI.Enums.FontScheme;
import GUI.Frame;
import GUI.setUp.setUpElements.GridSetting.SliderPanel;
import GUI.setUp.setUpElements.PlayerSettings.PlayerSettingPanel;
import exception.IllegalSetupException;
import exception.IllegalUserInputException;
import setUp.SetUp;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SetUpPanel extends JPanel implements ActionListener {
    SliderPanel widthSlider;
    SliderPanel heightSlider;
    JButton startButton;
    PlayerSettingPanel player1Settings;
    PlayerSettingPanel player2Settings;

    //delete after we can call it from model
    Frame frame;



    public SetUpPanel(Frame frame) {
        this.frame = frame;
        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());
        startPanel.setOpaque(false);
        startPanel.setPreferredSize(new Dimension(50, 50));
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100,40));
        startButton.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.PLAIN, 24));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setOpaque(true);
        startButton.setBackground(ColorScheme.MEDIUM_BRIGHT_COLOR.getColor());
        startPanel.add(startButton);
        this.add(startPanel, BorderLayout.SOUTH);

        JPanel playerSettings = new JPanel();
        playerSettings.setLayout(new FlowLayout());
        playerSettings.setPreferredSize(new Dimension(500, 250));
        playerSettings.setOpaque(false);
        player1Settings = new PlayerSettingPanel("Player 1", ColorScheme.MEDIUM_COLOR.getColor());
        playerSettings.add(player1Settings);
        player2Settings = new PlayerSettingPanel("Player 2", ColorScheme.DARK_COLOR.getColor());
        playerSettings.add(player2Settings);
        this.add(playerSettings, BorderLayout.NORTH);

        JPanel gameSettings = new JPanel();
        gameSettings.setLayout(new FlowLayout());
        gameSettings.setOpaque(false);
        widthSlider = new SliderPanel(40,80, 60, "Length");
        gameSettings.add(widthSlider);
        heightSlider = new SliderPanel(30,60, 45, "Height");
        gameSettings.add(heightSlider);
        this.add(gameSettings, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            //call method with
        int width = widthSlider.getValue();
        int height = heightSlider.getValue();
        //should be called from Model
        java.util.List<Color> playersColors = new ArrayList<Color>();
        java.util.List<String> playersNames = new ArrayList<String>();
        playersColors.add(player1Settings.getCurrentColor());
        playersColors.add(player2Settings.getCurrentColor());
        playersNames.add(player1Settings.getCurrentName());
        playersNames.add(player2Settings.getCurrentName());

        frame.setUpFinished(width, height);
        //frame.setUpFinished(playersColors,playersNames,width, height);
        SetUp setUp = new SetUp();
        try {
            setUp.setUp(playersColors,playersNames,height,width,1);
        } catch (IllegalSetupException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalUserInputException ex) {
            throw new RuntimeException(ex);
        }
    }
}
