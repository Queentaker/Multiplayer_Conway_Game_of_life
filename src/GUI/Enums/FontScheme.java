package GUI.Enums;

import java.awt.*;

public enum FontScheme {

    STANDARD_FONT("Rockwell");
    private final String fontName;

    FontScheme(String name) {
        fontName = name;
    }

    public String getName() {
        return fontName;
    }
}
