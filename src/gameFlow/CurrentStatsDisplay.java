package gameFlow;

import grid.Display;
import grid.Grid;

public class CurrentStatsDisplay implements GridObserver, Display {
    private int cellsAlivePlayer1;
    private int cellsAlivePlayer2;
    private int generationPlayer1;
    private int generationPlayer2;
    private Grid grid;

    @Override
    public void display() {
        //todo GUI should display the current stats after each turn
    }

    @Override
    public void update(int cellsAlivePlayer1, int cellsAlivePlayer2, int generationPlayer1, int generationPlayer2) {
        this.cellsAlivePlayer1 = cellsAlivePlayer1;
        this.cellsAlivePlayer2 = cellsAlivePlayer2;
        this.generationPlayer1 = generationPlayer1;
        this.cellsAlivePlayer2 = generationPlayer2;
        display();
    }
}
