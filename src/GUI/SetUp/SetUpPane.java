package GUI.SetUp;

import GUI.Frame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUpPane extends JPanel implements ActionListener, ChangeListener {
    SliderPanel lengthSlider;
    SliderPanel heightSlider;
    JButton startButton;
    JTextField player1Name;
    JTextField player2Name;
    JButton player1Color;
    JButton player2Color;
    //delete after we can call it from model
    Frame frame;

    public SetUpPane(Frame frame) {
        this.frame = frame;

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

        lengthSlider = new SliderPanel(50,100, 75);
        this.add(lengthSlider);
        heightSlider = new SliderPanel(50,100, 75);
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
            player1Color.getName();
            player2Name.getText();
            int length = lengthSlider.getValue();
            int height = heightSlider.getValue();
            //should be called from Model
            frame.setUpFinished(height, length);
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
