package GUI.setUp.setUpElements.GridSetting;

import GUI.Enums.ColorScheme;
import GUI.Enums.FontScheme;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderPanel extends JPanel implements ChangeListener {
    private final JSlider slider;
    private final JLabel number;

    public SliderPanel(int min, int max, int defaultValue, String Title) {
        this.setLayout(new BorderLayout());
        this.setOpaque(true);
        this.setBackground(ColorScheme.MEDIUM_BRIGHT_COLOR.getColor());

        JLabel title = new JLabel();
        title.setOpaque(true);
        title.setOpaque(false);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setText(Title);
        title.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.PLAIN, 24));
        title.setForeground(ColorScheme.DARK_COLOR.getColor());
        title.setPreferredSize(new Dimension(30,50));
        this.add(title, BorderLayout.NORTH);

        number = new JLabel();
        number.setHorizontalAlignment(JLabel.CENTER);
        number.setText(Integer.toString(defaultValue));
        number.setFont(new Font(FontScheme.STANDARD_FONT.getName(), Font.PLAIN, 24));
        number.setForeground(ColorScheme.DARK_COLOR.getColor());
        number.setPreferredSize(new Dimension(30,30));
        number.setOpaque(false);
        this.add(number, BorderLayout.SOUTH);

        slider = new JSlider(min, max, defaultValue);
        slider.setPreferredSize(new Dimension(300,60));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(50);
        slider.setPaintLabels(true);
        slider.setOrientation(SwingConstants.HORIZONTAL);
        slider.addChangeListener(this);
        this.add(slider, BorderLayout.CENTER);
    }

    public int getValue() {
        return slider.getValue();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        number.setText(Integer.toString(slider.getValue()));
    }
}
