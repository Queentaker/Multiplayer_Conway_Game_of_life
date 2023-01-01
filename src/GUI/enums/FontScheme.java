package GUI.enums;

public enum FontScheme {

    STANDARD_FONT("Times New Roman");

    private final String fontName;

    FontScheme(String name) {
        fontName = name;
    }

    public String getFontName() {
        return fontName;
    }
}
