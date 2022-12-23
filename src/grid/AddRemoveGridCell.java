package grid;

import exception.IllegalUserInputException;
import player.PlayersSignature;

//interface for player when he needs to add players
public interface AddRemoveGridCell {
    public void placeGridCell(PlayersSignature playersSignature,int x,int y) throws IllegalUserInputException;
    public void removeGridCell(PlayersSignature playersSignature, int x, int y)throws IllegalUserInputException;
}
