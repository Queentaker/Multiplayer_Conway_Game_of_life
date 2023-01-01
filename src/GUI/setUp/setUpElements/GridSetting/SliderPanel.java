package GUI.setUp.setUpElements.GridSetting;

import GUI.enums.ColorScheme;
import GUI.enums.FontScheme;

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
        this.setBorder(BorderFactory.createLineBorder(ColorScheme.BRIGHT_COLOR.getColor(), 12));
        JLabel title = new JLabel();
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setText(Title);
        title.setBackground(ColorScheme.BRIGHT_COLOR.getColor());
        title.setFont(new Font(FontScheme.STANDARD_FONT.getFontName(), Font.BOLD, 24));
        title.setForeground(ColorScheme.DARK_COLOR.getColor());
        title.setPreferredSize(new Dimension(30,30));
        this.add(title, BorderLayout.NORTH);
        number = new JLabel();
        number.setHorizontalAlignment(JLabel.CENTER);
        number.setText(Integer.toString(defaultValue));
        number.setFont(new Font(FontScheme.STANDARD_FONT.getFontName(), Font.PLAIN, 24));
        number.setForeground(ColorScheme.DARK_COLOR.getColor());
        number.setPreferredSize(new Dimension(30,30));
        number.setOpaque(false);
        this.add(number, BorderLayout.SOUTH);
        slider = new JSlider(min, max, defaultValue);
        slider.setOpaque(true);
        slider.setBackground(ColorScheme.MEDIUM_BRIGHT_COLOR.getColor());
        slider.setPreferredSize(new Dimension(300,60));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setOrientation(SwingConstants.HORIZONTAL);
        slider.addChangeListener(this);
        slider.setFont(new Font(FontScheme.STANDARD_FONT.getFontName(), Font.PLAIN, 10));
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
