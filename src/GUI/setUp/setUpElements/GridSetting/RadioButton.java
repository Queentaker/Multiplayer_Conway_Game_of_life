package GUI.setUp.setUpElements.GridSetting;

import GUI.GUI_Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.GUI_Utility.ImageNameToImageIcon;

public class RadioButton extends JRadioButton implements ActionListener {

    private final JRadioButton radioButton;
    private final ImageIcon patternIcon;

    public RadioButton(String imageName){

        radioButton = new JRadioButton();
        patternIcon = ImageNameToImageIcon(imageName,1080,1080);
        radioButton.setIcon(patternIcon);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
