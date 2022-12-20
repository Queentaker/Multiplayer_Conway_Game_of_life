package GUI.Enums.Grid;

import java.awt.*;

public enum GridColors {
    DEFAULT_GRID_BUTTON(new Color(0x000000));

    private final Color color;

    GridColors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
