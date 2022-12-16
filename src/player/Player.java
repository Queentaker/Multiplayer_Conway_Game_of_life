package player;

import java.util.UUID;

public abstract class Player implements PlayersSignature{
    private final String name;
    private final String  playerId;
    private final String signatureSymbol;
    public Player (String name,String signatureSymbol){
        this.name=name;
        this.signatureSymbol=signatureSymbol;
        this.playerId=UUID.randomUUID().toString();
    }
    @Override
    public String getPlayerId() {
        return playerId;
    }
    @Override
    public String getPlayerSymbol() {
        return signatureSymbol;
    }

    public String getName() {
        return name;
    }
}
