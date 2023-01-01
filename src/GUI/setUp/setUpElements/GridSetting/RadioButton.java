package GUI.setUp.setUpElements.GridSetting;

import javax.swing.*;

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
