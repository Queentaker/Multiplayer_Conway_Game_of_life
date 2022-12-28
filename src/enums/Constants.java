package enums;

public enum Constants {
    minAllowedPlayers(2),
    minHeight(20),
    maxHeight(40),
    minWidth(30),

    dist(4),
    maxWidth(60);

    public final int constant;
    Constants(Integer definedConstant){
        this.constant=definedConstant;
    }
}
