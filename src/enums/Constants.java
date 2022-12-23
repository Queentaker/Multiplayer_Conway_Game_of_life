package enums;

public enum Constants {
    minAllowedPlayers(2),
    minHeight(30),
    maxHeight(60),
    minWidth(40),
    maxWidth(70);

    public final int constant;
    Constants(Integer definedConstant){
        this.constant=definedConstant;
    }
}
