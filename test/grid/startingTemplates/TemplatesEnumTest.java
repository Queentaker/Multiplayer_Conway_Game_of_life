package grid.startingTemplates;

import grid.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.HumanPlayer;
import player.PlayersSignature;

import java.awt.*;

public class TemplatesEnumTest {
    PlayersSignature bobSignature =new HumanPlayer("bob", Color.BLUE);
    PlayersSignature annaSignature= new HumanPlayer("anna", Color.RED);
    Grid grid = new Grid(5,5);
    Template1 template1 = new Template1();
    Template2 template2 = new Template2();
    Template3 template3 = new Template3();
    Template4 template4 = new Template4();
    Template5 template5 = new Template5();
    Template6 template6 = new Template6();

    @Test
    public void Template1(){
        String expectedString = """
                oxooo
                oxxoo
                oxxoo
                ooooo
                ooooo
                """;
        template1.addCustomTemplate(0,0, grid, bobSignature);
        String actualString = GridToString.gridToString(grid);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void Template2(){
        String expectedString = """
                ooooo
                oxxxo
                xooox
                oxxxo
                ooooo
                """;
        template2.addCustomTemplate(0,0, grid, bobSignature);
        String actualString = GridToString.gridToString(grid);
        Assertions.assertEquals(expectedString, actualString);
    }
    @Test
    public void Template3(){
        String expectedString = """
                xoxox
                oxoxo
                xoxox
                oxoxo
                xoxox
                """;
        template3.addCustomTemplate(0,0, grid, bobSignature);
        String actualString = GridToString.gridToString(grid);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void Template4(){
        String expectedString = """
                xxxxx
                ooooo
                xxxxx
                ooooo
                xxxxx
                """;
        template4.addCustomTemplate(0,0, grid, bobSignature);
        String actualString = GridToString.gridToString(grid);
        Assertions.assertEquals(expectedString, actualString);
    }
    @Test
    public void Template5(){
        String expectedString = """
                oxxox
                xxoxx
                xoxxo
                oxxox
                xxoxx
                """;
        template5.addCustomTemplate(0,0, grid, bobSignature);
        String actualString = GridToString.gridToString(grid);
        Assertions.assertEquals(expectedString, actualString);
    }
    @Test
    public void Template6(){
        String expectedString = """
                xxxxx
                xooox
                xooox
                xooox
                xxxxx
                """;
        template6.addCustomTemplate(0,0, grid, bobSignature);
        String actualString = GridToString.gridToString(grid);
        Assertions.assertEquals(expectedString, actualString);
    }
}
