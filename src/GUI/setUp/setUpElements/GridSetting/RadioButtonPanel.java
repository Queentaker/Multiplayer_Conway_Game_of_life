package GUI.setUp.setUpElements.GridSetting;

import GUI.Enums.ColorScheme;
import GUI.Enums.FontScheme;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class RadioButtonPanel extends JPanel {
    ButtonGroup aButtonGroup;

    public RadioButtonPanel() {
        this.setOpaque(false);
        this.setLayout(new FlowLayout());

        JPanel container = new JPanel();
        container.setOpaque(true);
        container.setBorder(BorderFactory.createLineBorder(ColorScheme.BRIGHT_COLOR.getColor(), 12));
        container.setBackground(ColorScheme.BRIGHT_COLOR.getColor());
        container.setLayout(new BorderLayout());

        JLabel title = new JLabel("Start Layout");
        title.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.BOLD, 24));
        title.setForeground(ColorScheme.DARK_COLOR.getColor());
        title.setOpaque(false);
        title.setHorizontalAlignment(JLabel.CENTER);
        container.add(title, BorderLayout.NORTH);

        JPanel buttonContainer = new JPanel();
        buttonContainer.setOpaque(false);
        buttonContainer.setLayout(new FlowLayout());
        RadioButton radioButton1 = new RadioButton("RadioButton1", 1);
        RadioButton radioButton2 = new RadioButton("RadioButton2", 2);
        RadioButton radioButton3 = new RadioButton("RadioButton3", 3);
        RadioButton radioButton4 = new RadioButton("RadioButton4", 4);
        RadioButton radioButton5 = new RadioButton("RadioButton5", 5);
        RadioButton radioButton6 = new RadioButton("RadioButton6", 6);
        aButtonGroup = new ButtonGroup();
        aButtonGroup.add(radioButton1);
        aButtonGroup.add(radioButton2);
        aButtonGroup.add(radioButton3);
        aButtonGroup.add(radioButton4);
        aButtonGroup.add(radioButton5);
        aButtonGroup.add(radioButton6);
        buttonContainer.add(radioButton1);
        buttonContainer.add(radioButton2);
        buttonContainer.add(radioButton3);
        buttonContainer.add(radioButton4);
        buttonContainer.add(radioButton5);
        buttonContainer.add(radioButton6);
        radioButton1.setSelected(true);
        container.add(buttonContainer, BorderLayout.CENTER);
        JLabel borderLeft = new JLabel();
        borderLeft.setPreferredSize(new Dimension(1,1));
        this.add(borderLeft);
        this.add(container);
        JLabel borderRight = new JLabel();
        borderRight.setPreferredSize(new Dimension(1,1));
        this.add(borderRight);
    }

    public int getSelectedValue() {
        for(Enumeration<AbstractButton> buttons = aButtonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton aButton = buttons.nextElement();
            if (aButton.isSelected()) {
                if (aButton.getClass() == RadioButton.class) {
                    RadioButton button = (RadioButton) aButton;
                    return button.getValue();
                }
            }
        }
        return -1;
    }
}
