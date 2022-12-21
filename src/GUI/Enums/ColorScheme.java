package GUI.Enums;

import java.awt.*;

public enum ColorScheme {
    LIGHT_COLOR(new Color(0x999999)),
    MEDIUM_COLOR(new Color(0x555555)),
    BLUE_COLOR(new Color(1000)),
    GREEN_COLOR(new Color(1020000)),
    DARK_COLOR(new Color(0x000000));

    private final Color color;

    ColorScheme(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
