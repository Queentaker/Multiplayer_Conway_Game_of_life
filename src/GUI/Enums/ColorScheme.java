package GUI.Enums;

import java.awt.*;

public enum ColorScheme {
    BRIGHT_COLOR(new Color(228, 228, 232)),
    MEDIUM_BRIGHT_COLOR(new Color(217, 217, 250)),
    MEDIUM_COLOR(new Color(140, 140, 242)),
    MEDIUM_DARK_COLOR(new Color(76,76,154)),
    DARK_COLOR(new Color(79,77,73)),
    BACKGROUND_COLOR(new Color(255,255,255)),

    /// ???
    BLUE_COLOR(Color.BLUE),
    GREEN_COLOR(new Color(1020000));

    private final Color color;

    ColorScheme(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
