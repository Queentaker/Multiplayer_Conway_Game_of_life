package GUI.setUp.setUpElements.GridSetting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton extends JRadioButton implements ActionListener {

    private final JRadioButton radioButton;
    private final ImageIcon patternIcon;

    public RadioButton(String imageName){

        radioButton = new JRadioButton();
        patternIcon = new ImageIcon(imageName);
        radioButton.setIcon(patternIcon);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
