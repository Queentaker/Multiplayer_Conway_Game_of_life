package GUI.SetUp;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderPanel extends JPanel implements ChangeListener {
    JSlider slider;
    JLabel label;

    public SliderPanel(int min, int max, int defaultValue) {
        this.setLayout(new FlowLayout());

        slider = new JSlider(min, max, defaultValue);
        slider.setPreferredSize(new Dimension(300,200));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(50);
        slider.setPaintLabels(true);
        slider.setOrientation(SwingConstants.VERTICAL);

        slider.addChangeListener(this);
        this.add(slider);

        label = new JLabel();
        label.setOpaque(true);
        label.setText(Integer.toString(defaultValue));
        this.add(label);
    }

    public int getValue() {
        return slider.getValue();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText(Integer.toString(slider.getValue()));
    }
}
