package GUI.setUp.setUpElements.GridSetting;

import GUI.GUI_Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.GUI_Utility.ImageNameToImageIcon;

public class RadioButton extends JRadioButton implements ActionListener {

    private final ImageIcon patternIcon;

    public RadioButton(String imageName){
        patternIcon = ImageNameToImageIcon( "StartLayouts/" +imageName,75,75);
        this.setIcon(patternIcon);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
