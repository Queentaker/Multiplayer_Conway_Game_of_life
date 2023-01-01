package grid;

import exception.IllegalUserInputException;
import player.PlayersSignature;

public interface AddRemoveGridCell {
    public void placeGridCell(int a, int b, PlayersSignature playersSignature) throws IllegalUserInputException;
    public void removeGridCell(int a, int b, PlayersSignature playersSignature)throws IllegalUserInputException;
}
