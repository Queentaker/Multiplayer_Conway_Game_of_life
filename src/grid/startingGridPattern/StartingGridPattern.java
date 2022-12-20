package grid.startingGridPattern;

import grid.Grid;
import player.PlayersSignature;

import java.util.List;

public interface StartingGridPattern {
    public void addStartingGridPatterns(Grid grid, List<PlayersSignature> players);
    //todo implement class that creates the starting grid pattern for the players maybe this can be function instead
    //todo use strategy
    //make sure that it is the same and fair
}
