package grid.startingTemplates;

import grid.Grid;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;

public class TemplatesEnumTest {
    PlayersSignature bobSignature =new HumanPlayer("bob", Color.BLUE);
    PlayersSignature annaSignature= new HumanPlayer("anna", Color.RED);
    Grid grid = new Grid(30,30);
    Template3 template1 = new Template3();
    Template1 template2 = new Template1();
    Template2 template3 = new Template2();
    Template4 template4 = new Template4();
    Template5 template5 = new Template5();

    @Test
    public void Template1(){
        template1.addCustomTemplate(15-3,15-3,grid,bobSignature);
    }

    @Test
    public void Template2(){
        template2.addCustomTemplate(15-2,15-2,grid, bobSignature);
    }
    @Test
    public void Template3(){
        template3.addCustomTemplate(15-3,15-3,grid,bobSignature);

    }

    @Test
    public void Template4(){
        template4.addCustomTemplate(15-3,15-3,grid,bobSignature);
    }
    @Test
    public void Tempplate5(){
        template5.addCustomTemplate(15-3,15-3,grid,bobSignature);
    }
}
