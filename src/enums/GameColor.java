package enums;

import GUI.enums.ColorScheme;

import java.awt.*;

public enum GameColor {
    EmptyColor(ColorScheme.BACKGROUND_COLOR.getColor());

    public final Color color;
    GameColor(Color color){
        this.color=color;
    }
}
