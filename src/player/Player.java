package player;

import java.awt.*;
import java.util.UUID;

public abstract class Player implements PlayersSignature{
    private final String name;
    private final String  playerId;
    private final Color playersColor;
    public Player (String name, Color playersColor){
        this.name=name;
        this.playersColor=playersColor;
        this.playerId=UUID.randomUUID().toString();
    }
    @Override
    public String getPlayerId() {
        return playerId;
    }
    @Override
    public Color getPlayerColor() {
        return playersColor;
    }
    @Override
    public String getPlayerName() {
        return name;
    }
}
