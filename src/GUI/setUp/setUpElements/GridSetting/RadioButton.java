package GUI.setUp.setUpElements.GridSetting;

import GUI.GUI_Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.GUI_Utility.ImageNameToImageIcon;

public class RadioButton extends JRadioButton implements ActionListener {

    public RadioButton(String imageName){
        ImageIcon notSelectedIcon = ImageNameToImageIcon("startLayouts/notSelected/" + imageName, 75, 75);
        this.setIcon(notSelectedIcon);
        ImageIcon selectedIcon = ImageNameToImageIcon("startLayouts/selected/" + imageName, 75, 75);
        this.setSelectedIcon(selectedIcon);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
