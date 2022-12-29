package enums;

public enum Constants {
    minAllowedPlayers(2),
    minHeight(20),
    maxHeight(40),
    minWidth(30),

    dist(4),
    allowedPlayers(2),
    minimumRGBDistance(10),
    maxWidth(60);

    public final int constant;
    Constants(Integer definedConstant){
        this.constant=definedConstant;
    }
}
