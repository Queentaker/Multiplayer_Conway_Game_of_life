package GUI.setUp;

import GUI.Frame;
import GUI.setUp.setUpElements.GridSetting.SliderPanel;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SetUpPanel extends JPanel implements ActionListener, ChangeListener {
    SliderPanel widthSlider;
    SliderPanel heightSlider;
    JButton startButton;
    JTextField player1Name;
    JTextField player2Name;
    JButton player1Color;
    JButton player2Color;
    //delete after we can call it from model
    Frame frame;



    public SetUpPanel(Frame frame) {
        this.frame = frame;
        this.setOpaque(false);

        this.setLayout(new FlowLayout());
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        this.add(startButton);

        player1Color = new JButton("Player1 Color");
        player1Color.setOpaque(true);
        player1Color.setPreferredSize(new Dimension(200,100));
        player1Color.setBackground(Color.BLUE);
        player1Color.addActionListener(this);
        this.add(player1Color);

        player2Color = new JButton("Player2 Color");
        player2Color.setOpaque(true);
        player2Color.setPreferredSize(new Dimension(200,100));
        player2Color.setBackground(Color.RED);
        player2Color.addActionListener(this);
        this.add(player2Color);

        widthSlider = new SliderPanel(50,100, 75, "Length");
        this.add(widthSlider);
        heightSlider = new SliderPanel(50,100, 75, "Height");
        this.add(heightSlider);

        player1Name = new JTextField();
        player1Name.setText("Player1");
        player1Name.setPreferredSize(new Dimension(200,50));
        this.add(player1Name);

        player2Name = new JTextField();
        player2Name.setText("Player2");
        player2Name.setPreferredSize(new Dimension(200,50));
        this.add(player2Name);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            //call method with
            player1Color.getBackground();
            player2Color.getBackground();
            player1Name.getText();
            player2Name.getText();
            int width = widthSlider.getValue();
            int height = heightSlider.getValue();
            //should be called from Model
            java.util.List<Color> playersColors = new ArrayList<Color>();
            java.util.List<String> playersNames = new ArrayList<String>();
            playersColors.add(player1Color.getBackground());
            playersColors.add(player2Color.getBackground());
            playersNames.add(player1Name.getText());
            playersNames.add(player2Name.getText());

            frame.setUpFinished(width, height);
            //frame.setUpFinished(playersColors,playersNames,width, height);

        } else {
            if (e.getSource().getClass() == JButton.class) {
                JButton currentButton = (JButton) e.getSource();
                Color currentColor = currentButton.getBackground();
                Color color = JColorChooser.showDialog(null, "Pick a Color", currentColor);
                currentButton.setBackground(color);
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
