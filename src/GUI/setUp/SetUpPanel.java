package GUI.setUp;

import GUI.Enums.ColorScheme;
import GUI.Enums.FontScheme;
import GUI.GameFrame;
import GUI.setUp.setUpElements.GridSetting.RadioButtonPanel;
import GUI.setUp.setUpElements.GridSetting.SliderPanel;
import GUI.setUp.setUpElements.PlayerSettings.PlayerSettingPanel;
import exception.IllegalSetupException;
import exception.IllegalUserInputException;
import setUp.SetUp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SetUpPanel extends JPanel implements ActionListener {
    SliderPanel widthSlider;
    SliderPanel heightSlider;

    JButton startButton;
    PlayerSettingPanel player1Settings;
    PlayerSettingPanel player2Settings;

    RadioButtonPanel radioButtonPanel;

    //delete after we can call it from model
    GameFrame frame;




    public SetUpPanel(GameFrame frame) {
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
        player1Settings = new PlayerSettingPanel("Player 1", ColorScheme.MEDIUM_DARK_COLOR.getColor());
        playerSettings.add(player1Settings);
        player2Settings = new PlayerSettingPanel("Player 2", ColorScheme.DARK_COLOR.getColor());
        playerSettings.add(player2Settings);
        this.add(playerSettings, BorderLayout.NORTH);

        JPanel gameSettings = new JPanel();
        gameSettings.setOpaque(false);
        gameSettings.setLayout(new BorderLayout());

        JPanel dimensionsSettings = new JPanel();
        dimensionsSettings.setLayout(new FlowLayout());
        dimensionsSettings.setOpaque(false);
        widthSlider = new SliderPanel(20,60, 60, "Length");
        dimensionsSettings.add(widthSlider);
        heightSlider = new SliderPanel(20,40, 25, "Height");
        dimensionsSettings.add(heightSlider);
        gameSettings.add(dimensionsSettings, BorderLayout.NORTH);

        radioButtonPanel = new RadioButtonPanel();

        gameSettings.add(radioButtonPanel, BorderLayout.CENTER);

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

        frame.setUpFinished(width, height, playersColors.get(0), playersNames.get(0), playersColors.get(1), playersNames.get(1),
                3);
        SetUp setUp = new SetUp();
        try {
            setUp.setUp(playersColors,playersNames,height,width,1, frame);
        } catch (IllegalSetupException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalUserInputException ex) {
            throw new RuntimeException(ex);
        }
    }
}
