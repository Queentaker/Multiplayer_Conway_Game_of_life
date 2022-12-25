package GUI.Enums;

import java.awt.*;

public enum ColorScheme {
    BRIGHT_COLOR(new Color(0x999999)),
    MEDIUM_BRIGHT_COLOR(new Color(0x555555)),
    MEDIUM_COLOR(new Color(0x555555)),
    MEDIUM_DARK_COLOR(new Color(0x555555)),
    DARK_COLOR(new Color(0x000000)),
    BACKGROUND_COLOR(new Color(0xffffff)),

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
