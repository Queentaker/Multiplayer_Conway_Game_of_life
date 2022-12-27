package grid.startingTemplates;

import grid.Grid;
import player.Player;
import player.PlayersSignature;

import java.util.List;

public interface StartingTemplate {


    Grid returnStartingGridPattern(Player player);
    //todo implement class that creates the starting grid pattern for the players maybe this can be function instead
    //todo use strategy
    //make sure that it is the same and fair
}
