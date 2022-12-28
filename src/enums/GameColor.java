package enums;

import java.awt.*;

public enum GameColor {
    EmptyColor(Color.white);

    public final Color color;
    GameColor(Color color){
        this.color=color;
    }
}
