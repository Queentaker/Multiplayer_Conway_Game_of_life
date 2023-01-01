package GUI.enums;

public enum FontScheme {

    STANDARD_FONT("TimesRoman");

    private final String fontName;

    FontScheme(String name) {
        fontName = name;
    }

    public String getFontName() {
        return fontName;
    }
}
