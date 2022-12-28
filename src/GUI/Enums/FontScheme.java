package GUI.Enums;

import java.awt.*;

public enum FontScheme {
    //Charter, Bodoni 72, TimesRoman, PT Serif

    STANDARD_FONT("TimesRoman");
    private final String fontName;

    FontScheme(String name) {
        fontName = name;
    }

    public String getName() {
        return fontName;
    }
}
