package grid.startingTemplates;

import grid.Grid;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;
import java.util.ArrayList;

public class TemplateTest {
    PlayersSignature bobSignature =new HumanPlayer("bob", Color.BLUE);
    PlayersSignature annaSignature= new HumanPlayer("anna", Color.RED);
    Grid grid = new Grid(10,10);
    Template template = new Template() {
        @Override
        protected void addCustomTemplate(int a, int b, Grid grid, PlayersSignature signature) {
        }
    };
    @Test
    public void Template(){
        ArrayList<PlayersSignature> players = new ArrayList<PlayersSignature>();
        players.add(bobSignature);
        players.add(annaSignature);
        template.addTemplate(grid,players);
    }
}
