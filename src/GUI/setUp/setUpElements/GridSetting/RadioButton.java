package GUI.setUp.setUpElements.GridSetting;

import GUI.GUI_Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.GUI_Utility.ImageNameToImageIcon;

public class RadioButton extends JRadioButton {
    private final int value;

    public RadioButton(String imageName, int value){
        this.value = value;
        ImageIcon notSelectedIcon = ImageNameToImageIcon("startLayouts/notSelected/" + imageName, 75, 75);
        this.setIcon(notSelectedIcon);
        ImageIcon selectedIcon = ImageNameToImageIcon("startLayouts/selected/" + imageName, 75, 75);
        this.setSelectedIcon(selectedIcon);
    }

    public int getValue() {
        return value;
    }
}
