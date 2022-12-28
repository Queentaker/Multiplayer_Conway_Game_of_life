package GUI.setUp.setUpElements.GridSetting;

import javax.swing.*;

public class RadioButtonPanel extends JPanel {
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;

    public RadioButtonPanel() {
        radioButton1 = new RadioButton("StartLayouts/RadioButton1");
        radioButton2 = new RadioButton("StartLayouts/RadioButton2");
        radioButton3 = new RadioButton("StartLayouts/RadioButton3");
        radioButton4 = new RadioButton("StartLayouts/RadioButton4");
        radioButton5 = new RadioButton("StartLayouts/RadioButton5");
        JPanel radioButtonPanel = new JPanel();
        ButtonGroup aButtonGroup = new ButtonGroup();
        aButtonGroup.add(radioButton1);
        aButtonGroup.add(radioButton2);
        aButtonGroup.add(radioButton3);
        aButtonGroup.add(radioButton4);
        aButtonGroup.add(radioButton5);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(radioButton4);
        this.add(radioButton5);
        radioButton1.setSelected(true);
    }

    public int getSelectedValue() {
        return 1;
    }
}
